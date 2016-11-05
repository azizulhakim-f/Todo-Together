package com.azizulhakim.todotogether.fragment;

/**
 * Created by AZIZUL on 10/26/2016.
 */

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class GroupFollowedFragment extends GroupFragmentInterface {

    public GroupFollowedFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        Query groupListQuery = databaseReference.child("groups").limitToFirst(100);
        return groupListQuery;
    }
}
