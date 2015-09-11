package com.example.tse.listdirectorio;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tse.listdirectorio.Adapter.MyTabsPagerAdapter;
import com.example.tse.listdirectorio.Tabs.SlidingTabLayout;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolBar;
    private ViewPager tabsPager;
    private SlidingTabLayout tabsTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Para utilizar mi Toolbar personalizado
        toolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);

        // Configuracion para utilizar las Tabs
        tabsPager = (ViewPager) findViewById(R.id.tabsPager);
        tabsPager.setAdapter(new MyTabsPagerAdapter(getSupportFragmentManager(),MainActivity.this));
        tabsTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabsTabs.setCustomTabView(R.layout.custom_tab,R.id.tabText);
        tabsTabs.setDistributeEvenly(true);
        tabsTabs.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        tabsTabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        tabsTabs.setViewPager(tabsPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
