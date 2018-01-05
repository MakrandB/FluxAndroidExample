package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.dispatcher.*;
import com.fluxandroidexample.model.*;

import java.util.*;

import javax.inject.*;

/**
 * Used for creating the store change actions
 */
public class StoreActionCreator {

    private Dispatcher mDispatcher;

    @Inject
    public StoreActionCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public void emitStoreChangeEvent(List<Contact> contacts) {
        mDispatcher.dispatch(new StoreChangeEvent(contacts));
    }
}
