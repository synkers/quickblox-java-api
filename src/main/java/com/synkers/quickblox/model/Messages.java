package com.synkers.quickblox.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Messages {
    @SerializedName("skip")
    @Expose
    private Integer skip;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("items")
    @Expose
    private List<MessageItem> items = null;

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<MessageItem> getItems() {
        return items;
    }

    public void setItems(List<MessageItem> items) {
        this.items = items;
    }

}