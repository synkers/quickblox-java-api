package com.synkers.quickblox.model;

import java.util.List;

public class Dialogs {
    private int limit;
    private int skip;
    private List<Dialog> items;

    public Dialogs() {
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public List<Dialog> getItems() {
        return items;
    }

    public void setItems(List<Dialog> items) {
        this.items = items;
    }
}