package com.fluxandroidexample.store;

import com.fluxandroidexample.model.*;

import io.realm.*;

/**
 * Parent interface of the store
 */
public interface IStore {

    /**
     * Gets the Current list of contacts
     *
     * @return contact List
     */
    RealmResults<Contact> getContactList();
}
