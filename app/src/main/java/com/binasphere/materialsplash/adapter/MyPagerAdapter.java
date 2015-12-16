package com.binasphere.materialsplash.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.binasphere.materialsplash.R;

/**
 * Created by Kerstin on 2015/12/14.
 */
public class MyPagerAdapter extends PagerAdapter {
    private String[] title = new String[]{"lancer", "saber", "archer"};

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.color_pager_layout, container, false);
        container.addView(view);
        Log.d("Hymmnos", position + " position instantiateItem");
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
