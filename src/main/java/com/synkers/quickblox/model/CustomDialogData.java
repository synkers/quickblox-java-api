package com.synkers.quickblox.model;

import java.util.HashMap;
import java.util.Map;

public class CustomDialogData {
    private String class_name;
    private HashMap<String, Object> customParameters = new HashMap<String, Object>();

    public CustomDialogData(String class_name, HashMap<String, Object> customParameters) {
        this.class_name = class_name;
        this.customParameters = customParameters;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public HashMap<String, Object> getCustomParameters() {
        return customParameters;
    }

    public void setCustomParameters(HashMap<String, Object> customParameters) {
        this.customParameters = customParameters;
    }

    public HashMap<String, Object> assemble() {
        HashMap<String, Object> assembled = new HashMap<String, Object>();
        assembled.put("class_name", class_name);
        for (Map.Entry<String, Object> entry : customParameters.entrySet()) {
            assembled.put(entry.getKey(), entry.getValue());
        }
        return assembled;
    }

    @Override
    public String toString() {
        return "CustomDialogData{" +
                "class_name='" + class_name + '\'' +
                ", customParameters=" + customParameters +
                '}';
    }
}