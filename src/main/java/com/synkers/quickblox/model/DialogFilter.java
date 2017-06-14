package com.synkers.quickblox.model;

import java.util.HashMap;
import java.util.Map;

public class DialogFilter {
    private String className;
    private Map<String, String> options;

    public DialogFilter(String className, Map<String, String> options) {
        this.className = className;
        this.options = options;
    }

    public Map<String, String> assemble() {
        Map<String, String> assembled = new HashMap<String, String>();
        assembled.put("data[class_name]", className);
        for (Map.Entry<String, String> entry : options.entrySet()) {
            assembled.put("data[" + entry.getKey() + "]", entry.getValue());
        }
        return assembled;
    }
}