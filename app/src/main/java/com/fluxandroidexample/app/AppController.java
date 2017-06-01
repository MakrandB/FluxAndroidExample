package com.fluxandroidexample.app;

import android.app.*;

import io.realm.*;

/**
 */
public class AppController extends Application {

    private static AppController sAppController;

    public static Application getApplication() {
        if (sAppController == null) {
            sAppController = new AppController();
        }
        return sAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).
                name(Realm.DEFAULT_REALM_NAME).
                schemaVersion(0).
                deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
