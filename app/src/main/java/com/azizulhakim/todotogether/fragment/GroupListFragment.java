package com.azizulhakim.todotogether.fragment;

/**
 * Created by AZIZUL on 10/26/2016.
 */

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class GroupListFragment extends PostFragmentInterface {

    public GroupListFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        Query groupListQuery = databaseReference.child("user-groups").child(getUid());
        return groupListQuery;
    }
}
