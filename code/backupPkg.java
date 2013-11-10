for (/*each line as "line" in ssh.exec("dpkg --get-selections | sed 's/^.+[ \t]*deinstall[ \t]&*$//g")*/) {
    String pid = line.preg_replace("^([^ \t]+)[ \t]*install[ \t]*$","$1");
    if (ssh.exec("apt-cache policy " + pid) == "") { // if package isn't in current repos or was installed manually
        ssh.exec("redeb " + pid); //I just made that command up :) Remember, this is just a draft.
    } else {
        selections += line; //That variable came out of nowhere. It holds the selections file that you run with "dpkg --set-selections"
        selections += "\n";
    }
}
//Save sources file into zip
//Put "debs" folder into that zip (also delete the debs folder afterword)
//Make a new file cal "sel" (or something different) in the zip and write the contents of the "selections" variable into it
