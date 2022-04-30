package com.siqi.timestamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager;
    private LinearLayout llCalendar, llToday, llProject;
    private ImageView ivCalendar, ivToday, ivProject, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
        initTabView();
    }

    private void initTabView() {

    }

    private void initPage() {

    }

    @Override
    public void onClick(View view) {

    }
}