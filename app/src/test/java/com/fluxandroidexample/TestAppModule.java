package com.fluxandroidexample;

import com.fluxandroidexample.di.*;
import com.fluxandroidexample.store.*;

import org.mockito.*;

/**
 * Test App module extension of the {@link AppModule} used for unit testing
 */
public class TestAppModule extends AppModule {

    public TestAppModule() {
        super();
    }

    @Override
    public IStore providesStore() {
        return Mockito.mock(IStore.class);
    }
}
