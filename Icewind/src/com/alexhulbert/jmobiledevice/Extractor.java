package com.alexhulbert.jmobiledevice;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.*;
import org.apache.commons.io.FileUtils;

/**
 * Code that can extract a directory of files from within a jar file on the classpath
 * is harder to write than one might expect. This is because frameworks such as Java
 * Web Start (JavaWS, JNLP) obfuscate the JARs and make them hard to find. For example
 * in recent versions of JavaWS, Class.getResource() returns a URL that appears to
 * point to the original host of the JAR file, not anywhere on the local machine.
 * 
 * The upshot is there's lot of code out on the internet that purports to be able
 * to read from jar files on the classpath, but most of them don't work with JavaWS.

 * When some earlier code worked fine in the development environment but failed upon
 * deployment, I wrote this code.
 * 
 * This code works, with the proviso that there is a bug in JDK 1.5.0_16 that prevents
 * it from working. Versions 1.5.0_15 (and earlier) and 1.5.0_17 (and later) work fine.
 * See bug 6746185: http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6746185
 * 
 * @author Brian Cole
 */
public class Extractor {
    /**
     * constructor
     * 
     * @param sourceDirectory directory (in a jar on the classpath) to extract
     * @param inputDirectory the location to extract to
     * @throws IOException if an IO exception occurs
     */
    public Extractor(String sourceDirectory, String writeDirectory) throws IOException {
        // make sure write directory exists
        new File(writeDirectory).mkdirs();
        // extract into the write directory
        extract(sourceDirectory, writeDirectory);
    }

    /**
     * extract the subdirectory from a jar on the classpath to {@code writeDirectory}
     * 
     * @param sourceDirectory directory (in a jar on the classpath) to extract
     * @param writeDirectory the location to extract to
     * @throws IOException if an IO exception occurs
     */
    private void extract(String sourceDirectory, String writeDirectory) throws IOException {
        final URL dirURL = getClass().getResource(sourceDirectory);
        final String path = sourceDirectory.substring(1);

        if ((dirURL != null) && dirURL.getProtocol().equals("jar")) {
            final JarURLConnection jarConnection = (JarURLConnection) dirURL.openConnection();
            System.out.println("jarConnection is " + jarConnection);

            final ZipFile jar = jarConnection.getJarFile();

            final Enumeration<? extends ZipEntry> entries = jar.entries(); // gives ALL entries in jar

            while(entries.hasMoreElements()) {
                final ZipEntry entry = entries.nextElement();
                final String name = entry.getName();
                // System.out.println(name);
                if(!name.startsWith(path)) {
                    // entry in wrong subdir -- don't copy
                    continue;
                }
                final String entryTail = name.substring(path.length());

                final File f = new File(writeDirectory + File.separator + entryTail);
                if(entry.isDirectory()) {
                    // if its a directory, create it
                    final boolean bMade = f.mkdir();
                    System.out.println((bMade ? "  creating " : "  unable to create ") + name);
                } else {
                    System.out.println("  writing  " + name);
                    final InputStream is = jar.getInputStream(entry);
                    final OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
                    final byte buffer[] = new byte[4096];
                    int readCount;
                    // write contents of 'is' to 'os'
                    while((readCount = is.read(buffer)) > 0) {
                        os.write(buffer, 0, readCount);
                    }
                    os.close();
                    is.close();
                }
            }
        } else if(dirURL == null) {
            throw new IllegalStateException("can't find " + sourceDirectory + " on the classpath");
        } else {
            FileUtils.copyDirectory(new File(dirURL.getFile()), new File(writeDirectory));
        }
    }

}
