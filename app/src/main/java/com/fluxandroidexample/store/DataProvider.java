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

    RealmResults<Contact> getContactList() {
        return mRealm.where(Contact.class).findAll();
    }

    void addContact(Contact contact) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(contact);
        mRealm.commitTransaction();
    }
}
