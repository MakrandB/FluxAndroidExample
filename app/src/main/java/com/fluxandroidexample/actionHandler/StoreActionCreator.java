package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.dispatcher.*;
import com.fluxandroidexample.model.*;

import javax.inject.*;

import io.realm.*;

/**
 * Used for creating the store change actions
 */
public class StoreActionCreator {

    private Dispatcher mDispatcher;

    @Inject
    public StoreActionCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public void emitStoreChangeEvent(RealmResults<Contact> contacts) {
        mDispatcher.dispatch(new StoreChangeEvent(contacts));
    }
}
