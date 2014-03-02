package com.alexhulbert.jmobiledevice;

import static com.alexhulbert.jmobiledevice.Pymobiledevice.pi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.python.core.PyObject;

/**
 *
 * @author Taconut
 */
public class Shell extends Wrapper {
    private String clientID = Utils.unique();
    private AFC client;
    
    /**
     * Creates a new Shell instance
     */
    public Shell() {
        Pymobiledevice.use("pymobiledevice", "afc");
        pi.exec(id + "=afc.AFCShell()");
        pi.exec(clientID + "=" + id + ".afc");
        client = new AFC(clientID);
    }
    
    /**
     * Creates a new Shell instance on the specified device
     * @param lockdown A lockdown instance connected to you're device
     */
    public Shell(Lockdown lockdown) {
        Pymobiledevice.use("pymobiledevice", "afc");
        pi.exec(id + "=afc.AFCShell(" + lockdown.id + ")");
        pi.exec(clientID + "=" + id + ".afc");
        client = new AFC(clientID);
    }
    
    /**
     * Attaches a shell class to an existing AFCShell
     * @param ID The id of an already-existing AFC instance
     */
    public Shell(String ID) {
        id = ID;
        Pymobiledevice.use("pymobiledevice", "afc");
        pi.exec(clientID + "=" + id + ".afc");
        client = new AFC(clientID);
    }
    
    /**
     * Gets an AFC instance from a Shell object
     * @return An AFC Client linked to this Shell
     */
    public AFC client() {
        return client;
    }
    
    /**
     * Runs shell code on an iDevice
     * Valid commands are: pwd, ln, ls, cat, cd, mv, push, pull, info, about, mkdir, rmdir, and rm
     * @param code Shell code to run
     * @return The outputs of each command
     */
    public PyObject[] run(String code) {
        String[] lines = code.split("(;)|(\\n)");
        List<PyObject> rets = new ArrayList<PyObject>();
        for (String command : lines) {
            String opcode = command.trim().split(" ")[0];
            opcode = opcode.replace("ln", "link");
            opcode = opcode.replace("hd", "hexdump");
            opcode = opcode.replace("info", "infos");
            String operand = command.substring(opcode.length() + (command.length() - command.trim().length()) + 1);
            operand = operand.replace("'", "\\'"); //Escape quotes
            rets.add(pi.eval(id + ".do_" + opcode + "('" + operand + "')"));
        }
        return rets.toArray(new PyObject[rets.size()]);
    }
    
    /**
     * Gets the current directory
     * @return The current directory (relative to ~mobile/Documents
     */
    public String pwd() {
        return pi.eval(id + ".do_pwd('')").toString();
    }
    
    /**
     * Makes a link/shortcut
     * @param target The directory that the link should point to
     * @param directory The name of the link
     */
    public void ln(String target, String directory) {
        pi.exec(id + ".do_ln('" + target + " " + directory + "')");
    }
    
    /**
     * Changes the current directory
     * @param directory The directory to change to
     */
    public void cd(String directory) {
        pi.exec(id + ".do_cd('" + directory + "')");
    }
    
    /**
     * Gets the contents of a file
     * @param fileName The file to read
     * @return The contents of "fileName"
     */
    public String cat(String fileName) {
        return pi.eval(id + ".do_cat('" + fileName + "')").toString();
    }
    
    /**
     * List
     * @param directory The folder to view the files
     * @return The files/folders in "directory"
     */
    public String ls(String directory) {
        return pi.eval(id + ".do_ls('" + directory + "')").toString();
    }
    
    /**
     * List
     * @return The files/folders in the current directory 
     */
    public String ls() {
        return ls("./");
    }
    
    /**
     * Removes a file
     * @param fileName The file to remove
     */
    public void rm(String fileName) {
         pi.exec(id + ".do_rm('" + fileName + "')");
    }

    /**
     * Pulls a file from the iDevice and 
     * copies it onto the computer
     * @param local The destination file
     * @param remote The file to copy
     */
    public void pull(String remote, File local) {
        pull(remote + " " + local.getPath().replace("\\", "\\\\"));
    }
    
    /**
     * Pulls a file from the iDevice and 
     * copies it to the current directory
     * @param remote The file to copy
     */
    public void pull(String remote) {
        pi.exec(id + ".do_pull('" + remote + "')");
    }
    
    /**
     * Takes a local file and puts it onto the iDevice
     * @param local  Where the file on the computer is located
     * @param remote Where to put the file on the iDevice
     */
    public void push(File local, String remote) {
        pi.exec(id + ".do_push('" + remote + " " + local.getPath().replace("\\", "\\\\") + "')");
    }
    
    /**
     * Dumps the hex of a file
     * @param fileName The file to view the hex of
     * @return The file in raw hex
     */
    public String hd(String fileName) {
        return pi.eval(id + ".do_hexdump('" + fileName + "')").toString();
    }
    
    /**
     * Makes a new directory
     * @param dirName The directory to create
     */
    public void mkdir(String dirName) {
        pi.exec(id + ".do_mkdir('" + dirName + "')");
    }
    
    /**
     * Gets various information about the iDevice
     * @return JSON string of data
     */
    public String info() {
        return pi.eval(id + ".do_infos('')").toString();
    }
    
    /**
     * Recursively Removes a directory
     * @param dirName Directory to remove
     */
    public void rmdir(String dirName) {
        pi.exec(id + ".do_rmdir('" + dirName + "')");
    }
    
    /**
     * Renames or moves a file
     * @param oldName File to rename/move
     * @param newName New name/path for the file
     */
    public void mv(String oldName, String newName) {
        pi.exec(id + ".do_mv('" + oldName + " " + newName + "')");
    }

    /**
     * Gets information about a specific file
     * @param fileName The file to get information about
     * @return Info about the file
     */
    public String about(String fileName) {
        return pi.eval(id + ".do_about('" + fileName + "')").toString();
    }
}
