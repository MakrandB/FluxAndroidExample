package com.fluxandroidexample.actionHandler;

import java.util.*;

public class Action {
    private final String type;
    private final HashMap<String, Object> data;

    public Action(String type, HashMap<String, Object> data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public HashMap getData() {
        return data;
    }
}