package com.siqi.timestamp.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haibin.calendarview.CalendarView;
import com.siqi.timestamp.R;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class CalendarFragment extends Fragment {

    private TextView tvDate;
    private View rootView;
    private CalendarView calendarView;

    public CalendarFragment() {
        // Required empty public constructor
    }

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//        topCalendarView = this.getView().findViewById(R.id.id_cv_weekly_calendar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        tvDate = rootView.findViewById(R.id.id_tv_month_calendar);
        calendarView = rootView.findViewById(R.id.id_cv_calendar);
        initTvTodayDate();


//        tvDate.setText("iachoac");

        return rootView;
    }

    private void initTvTodayDate() {
        TextView tvTodayDate = rootView.findViewById(R.id.id_tv_today_date);
        Calendar calendar = Calendar.getInstance();
        int month_today = calendar.get(Calendar.MONTH);
        int date_today = calendar.get(Calendar.DAY_OF_MONTH);
        String month = new DateFormatSymbols().getMonths()[month_today].toUpperCase();
        tvTodayDate.setText("TODAY: "+date_today +" "+month);
    }
}