package com.adolph.jrm.lukouapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.adolph.jrm.lukouapplication.R;
import com.adolph.jrm.lukouapplication.Helper.SpalshHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView = null;
    SpalshHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.iv_bg);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f,1.0f);
        alphaAnimation.setDuration(3000);
        imageView.setAnimation(alphaAnimation);
        alphaAnimation.start();

        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_bg) {
            helper = helper.getIntance();

            if (helper.isFirstGo(getApplicationContext())) {
                startActivity(new Intent(MainActivity.this,GuideActivity.class));
            }else {
                startActivity(new Intent(MainActivity.this,MainViewActivity.class));
            }

        }
    }
}
