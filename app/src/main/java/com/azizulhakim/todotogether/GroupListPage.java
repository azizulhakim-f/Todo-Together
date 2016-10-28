package com.azizulhakim.todotogether;

/**
 * Created by AZIZUL on 10/28/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.azizulhakim.todotogether.fragment.GroupListFragment;
import com.google.firebase.auth.FirebaseAuth;

public class GroupListPage extends InterfaceActivity {

    private static final String TAG = "GroupListPage";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list_page);


        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new GroupListFragment()
                    //new RecentPostsFragment(),
                    ///new MyPostsFragment(),
                    //new MyTopPostsFragment(),
            };
            private final String[] mFragmentNames = new String[] {
                    "Groups"
                    ///getString(R.string.heading_recent),
                   // getString(R.string.heading_my_posts),
                   // getString(R.string.heading_my_top_posts)
            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        // Button launches CreateNewGroupPage
        findViewById(R.id.fab_new_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "group button clicked.");
                startActivity(new Intent(GroupListPage.this, CreateNewGroupPage.class));
            }
        });
    }

    /*
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LogInPage.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}