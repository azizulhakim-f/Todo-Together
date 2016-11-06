package com.azizulhakim.todotogether.fragment;

import com.azizulhakim.todotogether.FirebaseUtil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class TaskRecentFragment extends TaskFragmentInterface {

    public TaskRecentFragment() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        String groupkey = FirebaseUtil.getCurrentGroupID();
        return databaseReference.child("group-posts")
                .child(groupkey);
        // [END recent_posts_query]
    }
}
