package com.rehman.timeline.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.logging.Logger;

public abstract class Utility {

    public static <T> T convertJsonToObject(String json, Class<T> className) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return (T) objectMapper.readValue(json, className);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
