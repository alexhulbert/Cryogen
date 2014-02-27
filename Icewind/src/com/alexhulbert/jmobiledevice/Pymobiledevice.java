package com.alexhulbert.jmobiledevice;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Taconut
 */
public class Pymobiledevice {
    
    public static void main(String[] a) throws Exception {
        selfExtract();
    }
    
    public static void selfExtract() throws IOException {
        String s = Pymobiledevice.class.getClass().getResource("/pymobiledevice").getPath();
        if (s.contains("jar!")) {
            int excl = s.lastIndexOf("!");
            s = s.substring(0, excl);
            s = s.substring("file:/".length());
            Path workingDirPath = Files.createTempDirectory("demo");
            try (JarFile jf = new JarFile(s)) {
                Enumeration<JarEntry> entries = jf.entries();
                while (entries.hasMoreElements()) {
                    JarEntry je = entries.nextElement();
                    String name = je.getName();
                    if (je.isDirectory()) {
                        Path dir = workingDirPath.resolve(name);
                        Files.createDirectory(dir);
                    } else {
                        Path file = workingDirPath.resolve(name);
                        try (InputStream is = jf.getInputStream(je);) {
                            Files.copy(is, file, StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                }
            }
        }
    }
}