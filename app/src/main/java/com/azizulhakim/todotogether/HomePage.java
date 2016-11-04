
package com.azizulhakim.todotogether;

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

import com.azizulhakim.todotogether.fragment.TaskPopularFragment;
import com.azizulhakim.todotogether.fragment.TaskRecentFragment;
import com.azizulhakim.todotogether.fragment.TaskofMeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends InterfaceActivity {

    private static final String TAG = "HomePage";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        findViewById(R.id.fab_navigation).setVisibility(View.INVISIBLE);
        findViewById(R.id.fab_new_post).setVisibility(View.INVISIBLE);
        findViewById(R.id.fab_new_group).setVisibility(View.INVISIBLE);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    //new GroupListFragment(),
                    new TaskRecentFragment(),
                    new TaskofMeFragment(),
                    new TaskPopularFragment(),
            };
            private final String[] mFragmentNames = new String[] {
                    //"Groups",
                    "Recent Tasks",
                    "My Tasks",
                    "My Top Tasks"
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

        // Button launches CreateNewPostPage
        findViewById(R.id.fab_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visible = findViewById(R.id.fab_navigation).getVisibility();
                if(visible==View.INVISIBLE) {
                    findViewById(R.id.fab_navigation).setVisibility(View.VISIBLE);
                    findViewById(R.id.fab_new_post).setVisibility(View.VISIBLE);
                    findViewById(R.id.fab_new_group).setVisibility(View.VISIBLE);
                }
                else {
                    findViewById(R.id.fab_navigation).setVisibility(View.INVISIBLE);
                    findViewById(R.id.fab_new_post).setVisibility(View.INVISIBLE);
                    findViewById(R.id.fab_new_group).setVisibility(View.INVISIBLE);
                }
            }
        });
        findViewById(R.id.fab_navigation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, NavigationPage.class));
            }
        });
        findViewById(R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, CreateNewPostPage.class));
            }
        });
        findViewById(R.id.fab_new_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "group button clicked.");
                startActivity(new Intent(HomePage.this, CreateNewGroupPage.class));
            }
        });
    }

    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

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