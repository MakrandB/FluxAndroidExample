package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.model.*;

import java.util.*;

/**
 * Used for notifying the store changes
 */
public class StoreChangeEvent implements IStoreChangeEvent {

    private List<Contact> contacts;

    public StoreChangeEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public List<Contact> getCurrentState() {
        return this.contacts;
    }
}
