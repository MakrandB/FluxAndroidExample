package com.fluxandroidexample;

import com.fluxandroidexample.di.*;

import dagger.*;

/**
 */
@Component(modules = {AppModule.class})
public interface TestAppComponent extends AppComponent {
    void inject(ExampleUnitTest exampleUnitTest);
}
