package com.alexhulbert.jmobiledevice;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Taconut
 */
public class Pymobiledevice {
    public static boolean initiated;
    private static List<String> libraries = new ArrayList<String>();
    public static PythonInterpreter pi;
    
    static {
        init();
    }
    
    public static void init() {
        try {
            new Extractor("/pymobiledevice", "./tmp/pymobiledevice");
            pi = new PythonInterpreter();
            pi.exec("isEmbedded='true'");
            pi.exec("import sys");
            
            File[] libs = new File("./tmp/pymobiledevice/jar").listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".jar");
                }
            });
            for (File lib : libs) {
                pi.exec("sys.path.append('" + lib.getAbsolutePath().replace("\\", "\\\\") + "')");
            }
            
            pi.exec("sys.path.append('" + new File("./tmp/pymobiledevice").getAbsolutePath().replace("\\", "\\\\") + "')");
            initiated = true;
        } catch (IOException e) {
            initiated = new File("./tmp/pymobiledevice").exists();
        }
    }
    
    public static void cleanUp() {
        pi.cleanup();
        pi = new PythonInterpreter();
        libraries.clear();
        try {
            FileUtils.deleteDirectory(new File("./tmp"));
        } catch (Exception e) {}
        initiated = false;
    }
    
    public static void use(String location, String module) {
        String libID = location + "." + module;
        if (!libraries.contains(libID)) {
            pi.exec("from " + location + " import " + module);
            libraries.add(libID);
        }
    }
    
    public static void use(String location, String module, String alias) {
        String libID = location + "." + module + "@" + alias;
        if (!libraries.contains(libID)) {
            pi.exec("from " + location + " import " + module + "as " + alias);
            libraries.add(libID);
        }
    }
}