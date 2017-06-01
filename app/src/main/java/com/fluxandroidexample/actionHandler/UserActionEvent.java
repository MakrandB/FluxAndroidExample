package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.model.*;

/**
 * User action for notifying the user interaction
 */
public class UserActionEvent implements IUserActionEvent {

    private Contact contact;

    public UserActionEvent(Contact contact) {
        this.contact = contact;
    }

    @Override
    public Contact getUserActionData() {
        return this.contact;
    }
}
