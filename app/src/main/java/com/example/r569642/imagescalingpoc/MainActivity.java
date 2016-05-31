package com.example.r569642.imagescalingpoc;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    public ViewPager pagerView;
    private  ImageLoader imageLoader;
    public static String[] prgmNameList = {"fitXY", "centerInside", "fitCenter"};
    public static String[] prgmUrls = {"https://webtoolfeed.files.wordpress.com/2012/10/tumblr_mauu8flw7t1rhztfto1_1280.png",
            "http://cdn.wonderfulengineering.com/wp-content/uploads/2014/03/high-resolution-wallpapers-25.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/5/58/Sunset_2007-1.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageLoader = new ImageLoader(getApplicationContext());
        pagerView = (ViewPager) findViewById(R.id.viewPager);
        List<Fragment> fragments = getFragments();
        pagerView.setAdapter(new MyPageAdapter(getSupportFragmentManager(), fragments));
    }

    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();
        for(int i=0 ; i<prgmUrls.length;i++)
        {
            fList.add(MyFragment.newInstance(prgmUrls[i],imageLoader));
        }
        return fList;
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

