package com.fluxandroidexample.di;

import com.fluxandroidexample.ui.*;

import dagger.*;

/**
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
