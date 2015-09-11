package com.example.tse.listdirectorio.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tse.listdirectorio.R;

/**
 * Created by TSE on 11/09/2015.
 */
public class MyFragmentTabs  extends Fragment{
    private TextView textView;
    public static MyFragmentTabs getInstance(int position){
        MyFragmentTabs myFragmentTabs = new MyFragmentTabs();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragmentTabs.setArguments(args);
        return myFragmentTabs;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment,container,false);
        textView = (TextView) layout.findViewById(R.id.position);
        Bundle bundle = getArguments();
        if (bundle != null){
            textView.setText("hola :" + bundle.getInt("position"));
        }
        return layout;
    }
}
