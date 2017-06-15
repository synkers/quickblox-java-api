package com.synkers.quickblox.model;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.List;

public class DialogCreationRequest {
    private int type;
    private String name;
    private String occupants_ids;
    private HashMap<String, Object> data;

    public DialogCreationRequest(String name, DialogType dialogType, List<String> occupantIds) {
        this.name = name;
        this.type = dialogType.getValue();
        this.occupants_ids = StringUtils.join(occupantIds, ",");
    }

    public DialogCreationRequest(String name, DialogType dialogType, List<String> occupantIds, CustomDialogData customDialogData) {
        this.name = name;
        this.type = dialogType.getValue();
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