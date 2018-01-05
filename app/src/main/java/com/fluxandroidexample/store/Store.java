package com.fluxandroidexample.store;

import com.fluxandroidexample.actionHandler.*;
import com.fluxandroidexample.di.*;
import com.fluxandroidexample.model.*;
import com.squareup.otto.*;

import java.util.*;

import javax.inject.*;

/**
 * The store
 */
public class Store implements IStore {

    @Inject
    public DataProvider mDataProvider;
    @Inject
    public Bus mBus;
    @Inject
    public StoreActionCreator mStoreActionCreator;

    public Store() {
        DaggerAppComponent.builder().appModule(AppModule.getInstance())
                .build().inject(this);
        mBus.register(this);
    }

    @Override
    public List<Contact> getContactList() {
        return mDataProvider.getContactList();
    }

    @Subscribe
    public void observeUserActionEvent(UserActionEvent event) {
        Contact contact = event.getUserActionData();
        mDataProvider.addContact(contact);
        mStoreActionCreator.emitStoreChangeEvent(getContactList());
    }
}
