package com.azizulhakim.todotogether.fragment;

import com.azizulhakim.todotogether.FirebaseUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class TaskofMeFragment extends TaskFragmentInterface {

    public TaskofMeFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        String groupkey = FirebaseUtil.getCurrentGroupID();
        return databaseReference.child("group-posts")
                .child(groupkey);
    }
}
