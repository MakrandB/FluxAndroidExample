package com.fluxandroidexample.actionHandler;

import com.fluxandroidexample.model.*;

import java.util.*;

import io.realm.*;

/**
 */
public interface IStoreChangeEvent extends IEvent {
    RealmResults<Contact> getCurrentState();
}
