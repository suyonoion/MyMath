package com.suyonoion.mymath;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.suyonoion.mymath.Animasi.FoldingDrawerLayout;
import com.suyonoion.mymath.Menus.fragment_page1;
import com.suyonoion.mymath.Menus.fragment_page2;
import com.suyonoion.mymath.Menus.fragment_page3;
import com.suyonoion.mymath.Menus.fragment_page4;
import com.suyonoion.mymath.Menus.fragment_page5;

public class MainActivity extends AppCompatActivity {


    private FoldingDrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mAnimalTitles;

    static final boolean IS_HONEYCOMB = Build.VERSION.SDK_INT == Build.VERSION_CODES.HONEYCOMB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
        mAnimalTitles = getResources().getStringArray(R.array.namapagexml_array);
        mDrawerLayout = (FoldingDrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mAnimalTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @SuppressLint("NewApi")
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                if (IS_HONEYCOMB) {
                    invalidateOptionsMenu(); // creates call to
                    // onPrepareOptionsMenu()
                }
            }
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
            @SuppressLint("NewApi")
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                if (IS_HONEYCOMB) {
                    invalidateOptionsMenu(); // creates call to
                    // onPrepareOptionsMenu()
                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }


    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        Fragment fragment_page1 = new fragment_page1();
        Fragment fragment_page2 = new fragment_page2();
        Fragment fragment_page3 = new fragment_page3();
        Fragment fragment_page4 = new fragment_page4();
        Fragment fragment_page5 = new fragment_page5();
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position){
            case 0:
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment_page1).commit();
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment_page2).commit();
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment_page3).commit();
                break;
            case 3:
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment_page4).commit();
                break;
            case 4:
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment_page5).commit();
                break;
        }

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mAnimalTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
