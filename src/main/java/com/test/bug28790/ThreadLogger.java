package com.test.bug28790;

import java.nio.file.Path;

public class ThreadLogger {

    public static void logThreadDump() {
        try {
            System.out.println("_________ Thread dump start _______________");
            new ProcessBuilder("/bin/sh","-c", "jps | grep TestApp | grep -v grep | awk '{print $1}' | xargs kill -3")
                    .inheritIO()
                    .directory(Path.of("/bin").toFile())
                    .start();
        } catch (Exception e) {
            System.err.println("Failed to execute bash with command");
            e.printStackTrace();
        }
    }
}
