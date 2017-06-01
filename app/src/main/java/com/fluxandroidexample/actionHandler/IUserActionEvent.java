package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.model.*;

/**
 * Represents the User Action
 */
interface IUserActionEvent extends IEvent {
    Contact getUserActionData();
}
