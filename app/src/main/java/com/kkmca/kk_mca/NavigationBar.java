package com.kkmca.kk_mca;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NavigationBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
FragmentManager fManager;
FragmentTransaction tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fManager=getFragmentManager();
        tx=fManager.beginTransaction();
        tx.add(R.id.frame,new home());
        tx.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new home());
            tx.commit();
            // Handle the camera action
        } else if (id == R.id.admission) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new admission());
            tx.commit();
        } else if (id == R.id.faculty) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new faculty());
            tx.commit();

        } else if (id == R.id.library) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new library());
            tx.commit();
        } else if (id == R.id.nav_share) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new share());
            tx.commit();
        } else if (id == R.id.lab) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new labs());
            tx.commit();
        }else if (id == R.id.gallery) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new gallery());
            tx.commit();
        }else if (id == R.id.hostel) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new hostel());
            tx.commit();
        }else if (id == R.id.downloads) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new downloads());
            tx.commit();
        }else if (id == R.id.contact) {
            tx=fManager.beginTransaction();
            tx.replace(R.id.frame,new contactus());
            tx.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
