package com.fluxandroidexample.app;

import android.app.*;

import io.realm.*;

/**
 */
public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing the Realm DB
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).
                name(Realm.DEFAULT_REALM_NAME).
                schemaVersion(0).
                deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
