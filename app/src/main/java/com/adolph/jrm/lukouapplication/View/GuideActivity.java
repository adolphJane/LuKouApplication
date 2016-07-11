package com.adolph.jrm.lukouapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.adolph.jrm.lukouapplication.R;
import com.adolph.jrm.lukouapplication.Helper.ViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Adolph on 16/7/8.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private ArrayList<View> views;
    private View view1, view2, view3;
    private ImageView[] points;
    private int currentIndex;
    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        initView();
        initData();
    }

    private void initView() {

        LayoutInflater mLi = LayoutInflater.from(this);
        view1 = mLi.inflate(R.layout.guide_page_one, null);
        view2 = mLi.inflate(R.layout.guide_page_two, null);
        view3 = mLi.inflate(R.layout.guide_page_three, null);

        button = (ImageButton) findViewById(R.id.enter_btn);

        pager = (ViewPager) findViewById(R.id.viewpager);
        views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        adapter = new ViewPagerAdapter(views);
        adapter.notifyDataSetChanged();
    }

    private void initData() {
        // 设置监听
        pager.setOnPageChangeListener(this);
        // 设置适配器数据
        pager.setAdapter(adapter);
        initPoint(views.size());

        button.setOnClickListener(this);
    }

    private void initPoint(int views){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.point);

        points = new ImageView[views];

        //循环取得小点图片
        for (int i = 0; i < views; i++) {
            points[i] = (ImageView) linearLayout.getChildAt(i);
            points[i].setEnabled(true);
            points[i].setOnClickListener(this);
            points[i].setTag(i);
        }
        currentIndex = 0;
        points[currentIndex].setEnabled(false);
    }

    private void setCurView(int position){
        if (position < 0 || position >= 4) {
            return;
        }
        pager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
    private void setCurDot(int positon){
        if (positon < 0 || positon > 3 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);

        currentIndex = positon;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer)v.getTag();
        setCurView(position);
        setCurDot(position);

        if (v.getId() == R.id.enter_btn){
            startActivity(new Intent(GuideActivity.this,MainViewActivity.class));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurDot(position);
        if (position == 1) {
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}