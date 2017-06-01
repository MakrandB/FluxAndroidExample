package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.dispatcher.*;

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

    public void emitStoreChangeEvent(IStoreChangeEvent storeChangeEvent) {
        mDispatcher.dispatch(storeChangeEvent);
    }
}
