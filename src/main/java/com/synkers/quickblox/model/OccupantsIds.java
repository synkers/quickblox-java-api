package com.synkers.quickblox.model;

import java.util.List;

public class OccupantsIds {
    private List<Long> occupants_ids;

    public List<Long> getOccupants_ids() {
        return occupants_ids;
    }

    public void setOccupants_ids(List<Long> occupants_ids) {
        this.occupants_ids = occupants_ids;
    }

    public OccupantsIds() {
    }

    public OccupantsIds(List<Long> occupants_ids) {
        this.occupants_ids = occupants_ids;
    }
}