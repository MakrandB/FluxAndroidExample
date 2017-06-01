package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.model.*;

import java.util.*;

import io.realm.*;

/**
 * Used for notifying the store changes
 */
public class StoreChangeEvent implements IStoreChangeEvent {

    private RealmResults<Contact> contacts;

    public StoreChangeEvent(RealmResults<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public RealmResults<Contact> getCurrentState() {
        return this.contacts;
    }
}
