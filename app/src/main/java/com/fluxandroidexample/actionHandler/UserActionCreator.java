package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.dispatcher.*;

import javax.inject.*;

/**
 * Used for creating the user actions
 */
public class UserActionCreator {

    private Dispatcher mDispatcher;

    @Inject
    public UserActionCreator(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public void emitUserActionEvent(IUserActionEvent event) {
        mDispatcher.dispatch(event);
    }
}
