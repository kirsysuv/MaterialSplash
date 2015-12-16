package com.binasphere.materialsplash.listener;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Kerstin on 2015/12/16.
 */
public class OnPageChangeColorListener implements ViewPager.OnPageChangeListener {
    private ArgbEvaluator mEvaluator;
    private WeakReference<ViewPager> mVp;

    public OnPageChangeColorListener(ViewPager vp) {
        mEvaluator = new ArgbEvaluator();
        mVp = new WeakReference<ViewPager>(vp);
    }

    public OnPageChangeColorListener(ViewPager vp, int[] argbColor) {
        this(vp);
        mColors = argbColor;
    }

    public OnPageChangeColorListener(ViewPager vp, String[] argbColor) {
        this(vp);
        mColors = new int[argbColor.length];
        for (int i=0;i<argbColor.length;i++){
            mColors[i]= Color.parseColor(argbColor[i]);
        }
    }

    private int[] mColors;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("Color", "position " + position + " positionOffset" + positionOffset + " positionPix" + positionOffsetPixels);
        int startColor = mColors[position];
        int endColor = mColors[Math.min(position + 1, mColors.length - 1)];
        int currentColor = (int) mEvaluator.evaluate(positionOffset, startColor, endColor);
        mVp.get().setBackgroundColor(currentColor);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
