package com.azizulhakim.todotogether.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class TaskofMeFragment extends TaskFragmentInterface {

    public TaskofMeFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("user-posts")
                .child(getUid());
    }
}
