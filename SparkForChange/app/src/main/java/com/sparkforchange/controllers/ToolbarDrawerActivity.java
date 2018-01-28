package com.sparkforchange.controllers;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sparkforchange.R;

/**
 * Parent activity housing a toolbar with searchable and a navigation drawer for user.
 */
public class ToolbarDrawerActivity extends AppCompatActivity {
    /**
     * Drawer Layout
     */
    private DrawerLayout mDrawerLayout;
    /**
     * Action Bar Drawer Toggle
     */
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected  void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        // Associate Searchable with the SearchView
        final SearchManager searchManager =
            (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView =
            (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
            searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item)||
            super.onOptionsItemSelected(item);
    }

    @Override
    public void setContentView(final int layoutResID) {
        final DrawerLayout fullLayout = (DrawerLayout) getLayoutInflater()
            .inflate(R.layout.activity_drawer, null);
        final RelativeLayout actContent = (RelativeLayout) fullLayout.findViewById(R.id.content);
        actContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        getLayoutInflater().inflate(layoutResID, actContent, true);
        super.setContentView(fullLayout);

        final Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mDrawerLayout = (DrawerLayout) fullLayout.findViewById(R.id.drawer_layout);
        final NavigationView navView = (NavigationView) fullLayout.findViewById(R.id.navigation_view);

        final View header = navView.getHeaderView(0);
        final TextView usernameDraw = (TextView) header.findViewById(R.id.tV_username_header);
        final TextView emailDraw = (TextView) header.findViewById(R.id.tV_email_header);
        usernameDraw.setText("current user");
        emailDraw.setText("current email");

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navView.setNavigationItemSelectedListener(
            new NavigationView.OnNavigationItemSelectedListener() {

                // This method will trigger on item Click of navigation menu
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {

                    //Checking if the item is in checked state or not, if not make it in checked state
                    if (menuItem.isChecked()) {
                        menuItem.setChecked(false);
                    } else {
                        menuItem.setChecked(true);
                    }

                    //Closing drawer on item click
                    mDrawerLayout.closeDrawers();

                    //Check to see which item was being clicked and perform appropriate action
                    Intent it;
                    switch (menuItem.getItemId()) {
                        case R.id.home:
                            it = new Intent(ToolbarDrawerActivity.this, HomeActivity.class);
                            startActivity(it);
                            return true;

                        case R.id.profile:
                            it = new Intent(ToolbarDrawerActivity.this, ProfileActivity.class);
                            startActivity(it);
                            return true;

                        case R.id.donate:
                            it = new Intent(ToolbarDrawerActivity.this, DonateActivity.class);
                            startActivity(it);
                            return true;

                        case R.id.serve:
                            it = new Intent(ToolbarDrawerActivity.this, ServeActivity.class);
                            startActivity(it);
                            return true;

                        case R.id.spendSparks:
                            it = new Intent(ToolbarDrawerActivity.this, SpendSparksActivity.class);
                            startActivity(it);
                            return true;

                        case R.id.group:
                            it = new Intent(ToolbarDrawerActivity.this, GroupActivity.class);
                            startActivity(it);
                            return true;
                    }
                    return true;
                }
            });

        mDrawerToggle = new ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            myToolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {

            public void onDrawerOpened(View drawerView) {
                final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        //Initialize Toolbar as ActionBar
        if (myToolbar != null) {
            setSupportActionBar(myToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
            }
        }
    }

    /**
     * Hide the keyboard
     * @param view view
     */
    private void hideKeyboard(View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}