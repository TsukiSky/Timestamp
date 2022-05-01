package com.siqi.timestamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.siqi.timestamp.framgments.CalendarFragment;
import com.siqi.timestamp.framgments.FragmentAdapter;
import com.siqi.timestamp.framgments.ProjectFragement;
import com.siqi.timestamp.framgments.TodayFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager2 viewPager;
    private ImageView ivCalendar, ivToday, ivProject, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
        initTabView();
    }

    private void initTabView() {
        LinearLayout llCalendar = findViewById(R.id.id_tab_calendar);
        llCalendar.setOnClickListener(this);
        LinearLayout llToday = findViewById(R.id.id_tab_today);
        llToday.setOnClickListener(this);
        LinearLayout llProject = findViewById(R.id.id_tab_project);
        llProject.setOnClickListener(this);

        ivCalendar = findViewById(R.id.tab_iv_calendar);
        ivToday = findViewById(R.id.tab_iv_today);
        ivProject = findViewById(R.id.tab_iv_project);

        ivToday.setSelected(true);
        ivCurrent = ivToday;
    }

    private void initPage() {
        viewPager = findViewById(R.id.id_viewpage);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(CalendarFragment.newInstance());
        fragments.add(TodayFragment.newInstance());
        fragments.add(ProjectFragement.newInstance());

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(1, false);
        viewPager.setPageTransformer(null);
    }

    private void changeTab(int pos){
        ivCurrent.setSelected(false);

        switch (pos){
            case R.id.id_tab_calendar:
                viewPager.setCurrentItem(0, false);
                ivCalendar.setSelected(true);
                ivCurrent = ivCalendar;
                break;
            case R.id.id_tab_today:
                viewPager.setCurrentItem(1, false);
                ivToday.setSelected(true);
                ivCurrent = ivToday;
                break;
            case R.id.id_tab_project:
                viewPager.setCurrentItem(2,false);
                ivProject.setSelected(true);
                ivCurrent = ivProject;
        }
    }


    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }
}