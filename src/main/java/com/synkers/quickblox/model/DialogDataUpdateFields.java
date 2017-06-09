package com.synkers.quickblox.model;

import java.util.HashMap;

public class DialogDataUpdateFields {
    private String name;
    private String photo;
    private OccupantsIds push_all;
    private OccupantsIds pull_all;
    private HashMap<String, Object> data;


    /**
     * Updates fields of a chat + optionally custom data
     *
     * @param name             name of dialog
     * @param photo            photo id
     * @param push_all         push_all operator to add new occupants
     * @param pull_all         pull_all to remove occupants
     * @param customDialogData update custom dialog data
     */
    public DialogDataUpdateFields(String name, String photo, OccupantsIds push_all, OccupantsIds pull_all, CustomDialogData customDialogData) {
        this.name = name;
        this.photo = photo;
        this.push_all = push_all;
        this.pull_all = pull_all;
        this.data = customDialogData.assemble();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public OccupantsIds getPush_all() {
        return push_all;
    }

    public void setPush_all(OccupantsIds push_all) {
        this.push_all = push_all;
    }

    public OccupantsIds getPull_all() {
        return pull_all;
    }

    public void setPull_all(OccupantsIds pull_all) {
        this.pull_all = pull_all;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}