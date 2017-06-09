package com.synkers.quickblox.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dialog {
    @SerializedName("_id")
    public String id;
    public String created_at;
    public String updated_at;
    public String last_message;
    public String last_message_date_sent;
    public String last_message_user_id;
    public String name;
    public String photo;
    public List<Integer> occupants_ids;
    public int type;
    public String xmpp_room_jid;
    public int unread_messages_count;

    public Dialog() {
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "id='" + id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", last_message='" + last_message + '\'' +
                ", last_message_date_sent='" + last_message_date_sent + '\'' +
                ", last_message_user_id='" + last_message_user_id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", occupants_ids=" + occupants_ids +
                ", type=" + type +
                ", xmpp_room_jid='" + xmpp_room_jid + '\'' +
                ", unread_messages_count=" + unread_messages_count +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_message() {
        return last_message;
    }

    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public String getLast_message_date_sent() {
        return last_message_date_sent;
    }

    public void setLast_message_date_sent(String last_message_date_sent) {
        this.last_message_date_sent = last_message_date_sent;
    }

    public String getLast_message_user_id() {
        return last_message_user_id;
    }

    public void setLast_message_user_id(String last_message_user_id) {
        this.last_message_user_id = last_message_user_id;
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

    public List<Integer> getOccupants_ids() {
        return occupants_ids;
    }

    public void setOccupants_ids(List<Integer> occupants_ids) {
        this.occupants_ids = occupants_ids;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getXmpp_room_jid() {
        return xmpp_room_jid;
    }

    public void setXmpp_room_jid(String xmpp_room_jid) {
        this.xmpp_room_jid = xmpp_room_jid;
    }

    public int getUnread_messages_count() {
        return unread_messages_count;
    }

    public void setUnread_messages_count(int unread_messages_count) {
        this.unread_messages_count = unread_messages_count;
    }
}