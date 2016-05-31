package com.example.r569642.imagescalingpoc;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by r569642 on 5/12/16.
 */
public class MyFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private ImageLoader imageLoader;

    public static final MyFragment newInstance(String url,ImageLoader loader)

    {
        MyFragment f = new MyFragment();

        Bundle bdl = new Bundle(1);

        f.imageLoader = loader;

        bdl.putString(EXTRA_MESSAGE, url);

        f.setArguments(bdl);

        return f;

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        String message = getArguments().getString(EXTRA_MESSAGE);

        View v = inflater.inflate(R.layout.grid_view_cell, container, false);

        ImageView imageView = (ImageView)v.findViewById(R.id.imageView1);

        //DisplayImage function from ImageLoader Class

        imageLoader.displayImage(message,imageView);

        return v;

    }

}
