package com.fluxandroidexample.model;

import io.realm.*;
import io.realm.annotations.*;

/**
 */
public class Contact extends RealmObject {

    @PrimaryKey
    private String id;

    private String name;
    private String contactNumber;

    public Contact() {
    }

    public Contact(String name, String contactNumber) {
        id = String.valueOf(System.currentTimeMillis());
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
