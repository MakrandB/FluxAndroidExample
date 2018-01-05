package com.fluxandroidexample.di;

import com.fluxandroidexample.actionHandler.*;
import com.fluxandroidexample.dispatcher.*;
import com.fluxandroidexample.store.*;
import com.squareup.otto.*;

import dagger.*;
import io.realm.*;

/**
 * App module defining the possible dependencies
 */
@Module
public class AppModule {

    private static final Bus sBus = new Bus();
    private static AppModule sAppModule;

    public AppModule() {
    }

    /**
     * Gets the app module instance
     *
     * @return AppModule instance
     */
    public static AppModule getInstance() {
        if (sAppModule == null) {
            sAppModule = new AppModule();
        }
        return sAppModule;
    }

    @Provides
    public Dispatcher providesDispatcher() {
        return new Dispatcher(providesBus());
    }

    @Provides
    public UserActionCreator providesUserActionCreator() {
        return new UserActionCreator(providesDispatcher());
    }

    @Provides
    public StoreActionCreator providesStoreActionCreator() {
        return new StoreActionCreator(providesDispatcher());
    }

    @Provides
    public DataProvider providesDataProvider() {
        return new DataProvider(Realm.getDefaultInstance());
    }

    @Provides
    public IStore providesStore() {
        return new Store();
    }

    @Provides
    public Bus providesBus() {
        return sBus;
    }
}
