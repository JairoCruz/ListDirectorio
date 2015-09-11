package com.example.tse.listdirectorio.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.tse.listdirectorio.Fragment.MyFragmentTabs;
import com.example.tse.listdirectorio.R;

/**
 * Created by TSE on 11/09/2015.
 */
public class MyTabsPagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    int icon[] = {R.mipmap.ic_action_collection, R.mipmap.ic_action_view_as_list};
    String [] tabText;
    public MyTabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabText = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        MyFragmentTabs myFragmentTabs = MyFragmentTabs.getInstance(position);
        return myFragmentTabs;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable = context.getResources().getDrawable(icon[position]);
        drawable.setBounds(0,0,36,36);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
