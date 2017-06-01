package com.fluxandroidexample.ui;

import android.app.*;
import android.content.*;
import android.support.annotation.*;
import android.support.design.widget.*;
import android.text.*;
import android.view.*;
import android.widget.*;

import com.fluxandroidexample.*;
import com.fluxandroidexample.model.*;

/**
 */
class AddContactDialog extends Dialog {

    private TextInputLayout mTILContactName;
    private TextInputLayout mTILContactNumber;
    private EditText mEtContactName;
    private EditText mEtContactNumber;

    AddContactDialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_contact_dialog_layout);
        mTILContactName = (TextInputLayout) findViewById(R.id.til_contact_name);
        mTILContactNumber = (TextInputLayout) findViewById(R.id.til_contact_number);
        mEtContactNumber = (EditText) findViewById(R.id.et_contact_number);
        mEtContactName = (EditText) findViewById(R.id.et_contact_name);
        findViewById(R.id.btn_save).setOnClickListener((MainActivity) context);
    }

    /**
     * Returns the enter details by wrapping them in Contact object
     *
     * @return Contact object
     */
    Contact getEnteredContact() {
        return isValidDataEntered() ? new Contact(mEtContactName.getText().toString
                (), mEtContactNumber.getText().toString()) : null;
    }

    /**
     * Checks whether the entered data is valid
     *
     * @return true if entered data is valid
     */
    private boolean isValidDataEntered() {
        boolean isValidDataEntered = true;
        if (TextUtils.isEmpty(mEtContactName.getText().toString())) {
            isValidDataEntered = false;
            mTILContactNumber.setError("Please enter contact name");
        } else {
            mTILContactNumber.setErrorEnabled(false);
        }

        if (TextUtils.isEmpty(mEtContactNumber.getText().toString()) || mEtContactNumber.getText()
                .toString().length() != 10) {
            isValidDataEntered = false;
            mTILContactName.setError("Please enter valid contact number");
        } else {
            mTILContactName.setErrorEnabled(false);
        }
        return isValidDataEntered;
    }
}
