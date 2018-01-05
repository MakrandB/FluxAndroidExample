package com.fluxandroidexample.store;

import com.fluxandroidexample.model.*;

import java.util.*;

/**
 * Parent interface of the store
 */
public interface IStore {

    /**
     * Gets the Current list of contacts
     *
     * @return contact List
     */
    List<Contact> getContactList();
}
