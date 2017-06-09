package com.fec.ex.sensorz.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.fec.ex.sensorz.R;

public class SensorListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView nv;
    private TextView tvNvFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpToolbar();
        nv = (NavigationView) findViewById(R.id.nvView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        setUpDrawer(nv);
        tvNvFooter = (TextView) findViewById(R.id.nvFooter);
        setUpFooter();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new SensorListFragment();
        ft.add(fragment, "SensorList");
        ft.replace(R.id.SensorListPlaceholder, fragment);
        ft.commit();
    }

    private void setUpFooter() {
        tvNvFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().addToBackStack("SensorList").replace(R.id.SensorListPlaceholder, new SettingsFragment()).commit();
            }
        });
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
    private void setUpDrawer(NavigationView nv) {
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
