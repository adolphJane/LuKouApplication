package com.adolph.jrm.lukouapplication.Helper;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Adolph on 16/7/10.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private ArrayList<View> views;

    public ViewPagerAdapter (ArrayList<View> views){
        this.views = views;
    }

    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    public Object instantiateItem(View view, int position) {

        ((ViewPager) view).addView(views.get(position), 0);

        return views.get(position);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public void destroyItem(View view, int position, Object arg2) {
        ((ViewPager) view).removeView(views.get(position));
    }

}
