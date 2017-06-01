package com.fluxandroidexample.ui;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import com.fluxandroidexample.*;
import com.fluxandroidexample.actionHandler.*;
import com.fluxandroidexample.di.*;
import com.fluxandroidexample.model.*;
import com.fluxandroidexample.store.*;
import com.squareup.otto.*;

import javax.inject.*;

import io.realm.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Dependencies to be injected
    @Inject
    Store mStore;
    @Inject
    UserActionCreator mUserActionCreator;
    @Inject
    Bus mEventBus;

    private AddContactDialog mAddContactDialog;
    private ContactRecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerAppComponent.builder().appModule(AppModule.getInstance())
                .build().inject(this);
        initResources();
    }

    /**
     * Initialize resources
     */
    private void initResources() {
        mEventBus.register(this);
        findViewById(R.id.fab_add_contact).setOnClickListener(this);
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rv_contacts);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContacts.setLayoutManager(layoutManager);
        mRecyclerViewAdapter = new ContactRecyclerViewAdapter(mStore.getContactList());
        rvContacts.setAdapter(mRecyclerViewAdapter);
    }

    @Subscribe
    public void onStoreDataChanged(StoreChangeEvent event) {
        Toast.makeText(this, "New contact added successfully", Toast.LENGTH_SHORT).show();
        refreshUi(event.getCurrentState());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_contact:
                mAddContactDialog = new AddContactDialog(MainActivity.this);
                mAddContactDialog.show();
                break;
            case R.id.btn_save:
                if (mAddContactDialog != null && mAddContactDialog.isShowing()) {
                    if (mAddContactDialog.getEnteredContact() != null) {
                        mUserActionCreator.emitUserActionEvent(new UserActionEvent
                                (mAddContactDialog.getEnteredContact()));
                        mAddContactDialog.dismiss();
                    }
                }
                break;
        }
    }

    /**
     * Refreshes the Ui
     *
     * @param contactsList updated contact list
     */
    private void refreshUi(RealmResults<Contact> contactsList) {
        mRecyclerViewAdapter.refreshData(contactsList);
    }
}
