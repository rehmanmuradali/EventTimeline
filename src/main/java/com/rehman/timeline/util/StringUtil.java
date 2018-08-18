package com.rehman.timeline.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class StringUtil {

    public static String getHardCodedEventsJson() {
        try {
            return new String(Files.readAllBytes(Paths.get("test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
