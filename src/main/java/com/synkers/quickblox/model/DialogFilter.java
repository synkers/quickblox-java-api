package com.synkers.quickblox.model;

import java.util.HashMap;
import java.util.Map;

public class DialogFilter {
    private String className;
    private Map<String, String> options;
    private DialogType dialogType;

    public DialogFilter(String className, Map<String, String> options, DialogType dialogType) {
        this.className = className;
        this.options = options;
        this.dialogType = dialogType;
    }

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
        if (dialogType != null) {
            assembled.put("type", String.valueOf(dialogType.getValue()));
        }
        return assembled;
    }
}