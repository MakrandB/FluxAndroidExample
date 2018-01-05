package com.fluxandroidexample.store;

import com.fluxandroidexample.model.*;

import io.realm.*;

/**
 * Data provider class
 */
public class DataProvider {

    private Realm mRealm;

    public DataProvider(Realm realm) {
        mRealm = realm;
    }

    /**
     * Gets the Contact List
     *
     * @return RealmResults list
     */
    RealmResults<Contact> getContactList() {
        return mRealm.where(Contact.class).findAll();
    }

    /**
     * Adds new contact to DB
     *
     * @param contact contact to be added
     */
    public void addContact(Contact contact) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(contact);
        mRealm.commitTransaction();
    }
}
