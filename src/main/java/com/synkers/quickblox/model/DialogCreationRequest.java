package com.synkers.quickblox.model;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.List;

public class DialogCreationRequest {
    private int type;
    private String name;
    private String occupants_ids;
    private HashMap<String, Object> data;

    public DialogCreationRequest(String name, Type type, List<String> occupantIds) {
        this.name = name;
        this.type = type.getValue();
        this.occupants_ids = StringUtils.join(occupantIds, ",");
    }

    public DialogCreationRequest(String name, Type type, List<String> occupantIds, CustomDialogData customDialogData) {
        this.name = name;
        this.type = type.getValue();
        this.occupants_ids = StringUtils.join(occupantIds, ",");
        this.data = customDialogData.assemble();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupants_ids() {
        return occupants_ids;
    }

    public void setOccupants_ids(String occupants_ids) {
        this.occupants_ids = occupants_ids;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public enum Type {
        PUBLIC_GROUP(1), GROUP(2), PRIVATE(3);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "DialogCreationRequest{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", occupants_ids='" + occupants_ids + '\'' +
                ", data=" + data +
                '}';
    }
}