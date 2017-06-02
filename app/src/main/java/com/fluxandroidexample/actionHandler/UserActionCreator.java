package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.dispatcher.*;
import com.fluxandroidexample.model.*;

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

    /**
     * Published  the user event
     *
     * @param contact the contact information
     */
    public void emitUserActionEvent(Contact contact) {
        mDispatcher.dispatch(new UserActionEvent(contact));
    }
}
