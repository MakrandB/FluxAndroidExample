package com.fluxandroidexample.store;

import com.fluxandroidexample.actionHandler.*;
import com.fluxandroidexample.model.*;
import com.squareup.otto.*;

import java.util.*;

import javax.inject.*;

import io.realm.*;

/**
 * The store
 */
public class Store {
    private StoreActionCreator mStoreActionCreator;
    private List<Contact> mContacts = new ArrayList<>();
    private DataProvider mDataProvider;

    @Inject
    public Store(Bus bus, StoreActionCreator storeActionCreator, DataProvider dataProvider) {
        mStoreActionCreator = storeActionCreator;
        bus.register(this);
        mDataProvider = dataProvider;
    }

    public RealmResults<Contact> getContactList() {
        return mDataProvider.getContactList();
    }

    @Subscribe
    public void observeUserActionEvent(UserActionEvent event) {
        Contact contact = event.getUserActionData();
        mDataProvider.addContact(contact);
        mStoreActionCreator.emitStoreChangeEvent(new StoreChangeEvent(getContactList()));
    }
}
