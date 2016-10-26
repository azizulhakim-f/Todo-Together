package com.azizulhakim.todotogether;

/**
 * Created by AZIZUL on 9/18/2016.
 */
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class InterfaceActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }


    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

}
