package com.azizulhakim.todotogether;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by AZIZUL on 11/6/2016.
 */
public class AddUserPage extends InterfaceActivity {
    private static final String TAG = "AddUserPage";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    private DatabaseReference mUserRef;
    // [END declare_database_ref]

    private EditText mMailField;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page__add_user);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        mMailField = (EditText) findViewById(R.id.user_mail);
        mSubmitButton = (Button) findViewById(R.id.submit_button);



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void addUser() {
        final String mail = mMailField.getText().toString();

        // Mail is required
        if (TextUtils.isEmpty(mail)) {
            mMailField.setError(REQUIRED);
            return;
        }

        // Disable button so there are no multi-posts
        setEditingEnabled(false);
        Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();

        // [START single_value_read]
        final String userId = getUid();

        // [ ADD USE START ]

        mUserRef = FirebaseUtil.getUserReference();





    }

    private void setEditingEnabled(boolean enabled) {
        mMailField.setEnabled(enabled);
        if (enabled) {
            mSubmitButton.setVisibility(View.VISIBLE);
        } else {
            mSubmitButton.setVisibility(View.GONE);
        }
    }

    // [START write_fan_out]

    // [END write_fan_out]
}
