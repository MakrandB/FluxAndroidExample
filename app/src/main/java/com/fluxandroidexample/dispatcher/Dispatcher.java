package com.fluxandroidexample.dispatcher;

import com.fluxandroidexample.actionHandler.*;
import com.squareup.otto.*;

import java.util.*;

import javax.inject.*;

/**
 * Responsible for dispatching the event over the event bus
 */
public class Dispatcher {

    private Bus mBus;

    @Inject
    public Dispatcher(Bus bus) {
        this.mBus = bus;
    }

    /**
     * dispatches the Event over the Event bus
     *
     * @param actionType : action type
     * @param object     : the data to be sent with the event
     */
    public void dispatch(String actionType, Object... object) {
        HashMap<String, Object> actionObject = new HashMap<>();
        int i = 0;
        while (i < object.length) {
            String key = (String) object[i++];
            Object value = object[i++];
            actionObject.put(key, value);
        }
        mBus.post(new Action(actionType, actionObject));
    }

    /**
     * Dispatches the given Event over the Event Bus
     *
     * @param event : Even to  be dispatched
     */
    public void dispatch(IEvent event) {
        mBus.post(event);
    }
}
