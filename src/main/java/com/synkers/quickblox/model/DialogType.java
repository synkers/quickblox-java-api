package com.synkers.quickblox.model;

public enum DialogType {
    PUBLIC_GROUP(1), GROUP(2), PRIVATE(3);

    private final int value;

    DialogType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}