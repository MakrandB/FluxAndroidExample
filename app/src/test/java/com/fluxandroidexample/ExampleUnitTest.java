package com.fluxandroidexample;

import com.fluxandroidexample.di.*;
import com.fluxandroidexample.model.*;
import com.fluxandroidexample.store.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {

    @Mock
    public IStore mStore;

    @Before
    public void setup() {
        TestAppComponent component = DaggerAppComponent.builder()
                .appModule(new TestAppModule()).build();
        component.inject(this);

    }

    @Test
    public void testStore() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Makrand", "9766801701"));
        Mockito.when(mStore.getContactList()).thenReturn(contacts);
        assertEquals(1, mStore.getContactList().size());
        assertEquals("9766801701", mStore.getContactList().get(0).getContactNumber());
        assertEquals("Makrand", mStore.getContactList().get(0).getName());
    }
}