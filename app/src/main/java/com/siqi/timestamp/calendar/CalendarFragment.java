package com.siqi.timestamp.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.siqi.timestamp.R;

import java.text.DateFormatSymbols;

public class CalendarFragment extends Fragment {

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
        calendarView = rootView.findViewById(R.id.id_cv_calendar);
        innitCalendarView();
        setTvTodayDate();
        setTvSelectedMonth();
        setTvSelectedDate();


        return rootView;
    }

    private void innitCalendarView() {
        calendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
            @Override
            public void onCalendarOutOfRange(Calendar calendar) {}

            @Override
            public void onCalendarSelect(Calendar calendar, boolean isClick) {
                setTvSelectedMonth();
                setTvSelectedDate();
            }
        });
    }

    private void setTvSelectedDate() {
        TextView tvSelectedDate = rootView.findViewById(R.id.id_tv_date_calendar);
        int dateSelected = calendarView.getCurDay();
        if (calendarView.getSelectedCalendar().isAvailable()) {
            dateSelected = calendarView.getSelectedCalendar().getDay();
        }
        tvSelectedDate.setText(String.valueOf(dateSelected));
    }

    public void setTvSelectedMonth() {
        TextView tvSelectedMonth = rootView.findViewById(R.id.id_tv_month_calendar);
        int monthSelected = calendarView.getCurMonth();
        if (calendarView.getSelectedCalendar().isAvailable()) {
            monthSelected = calendarView.getSelectedCalendar().getMonth();
        }
        String month = new DateFormatSymbols().getMonths()[monthSelected - 1].toUpperCase();
        tvSelectedMonth.setText(month);
    }

    private void setTvTodayDate() {
        TextView tvTodayDate = rootView.findViewById(R.id.id_tv_today_date);
        int monthToday = calendarView.getCurMonth();
        String month = new DateFormatSymbols().getMonths()[monthToday-1].toUpperCase();
        tvTodayDate.setText("TODAY: "+calendarView.getCurDay() +" "+month);
    }
}