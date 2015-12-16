package com.binasphere.materialsplash;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.binasphere.materialsplash.adapter.MyPagerAdapter;
import com.binasphere.materialsplash.listener.OnPageChangeColorListener;

public class SplashActivity extends AppCompatActivity {
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_splash);

        ViewPager vp = (ViewPager) findViewById(R.id.vp_splash);
        int[] colors = new int[]{0xFF03A9F4, 0xFFE91E63, 0xFFFF9800, 0x00FF9800};
        vp.addOnPageChangeListener(new OnPageChangeColorListener(vp, colors));
        vp.setAdapter(new MyPagerAdapter());
        setResult(1);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                       @Override
                                       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                       }

                                       @Override
                                       public void onPageSelected(int position) {
                                           if (position == 3) {

                                               SplashActivity.this.
                                                       finish();
                                               overridePendingTransition(R.anim.alpha_in_anim, R.anim.left_out_anim);
                                           }
                                       }

                                       @Override
                                       public void onPageScrollStateChanged(int state) {
                                       }
                                   }

        );
        flag = false;
    }

}
