package com.siqi.timestamp.calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.siqi.timestamp.R;

import java.text.DateFormatSymbols;

public class CalendarFragment extends Fragment {

    private View rootView;
    private CalendarView calendarView;
    int actualCurrentMonth;
    Button BtMonthView;
    Button BtWeekView;
    private CalendarLayout calendarLayout;

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
        calendarLayout = rootView.findViewById(R.id.id_calendar_layout);
        innitCalendarView();
        innitButton();
        setTvTodayDate();
        setTvSelectedMonth();
        setTvSelectedDate();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        actualCurrentMonth = calendar.get(java.util.Calendar.MONTH)+1;
        return rootView;
    }

    private void innitButton() {
        BtMonthView = rootView.findViewById(R.id.id_bt_month_calendar);
        BtWeekView = rootView.findViewById(R.id.id_bt_week_calendar);
        BtMonthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarLayout.expand();
                BtMonthView.setBackgroundResource(R.drawable.bg_button_light_style_selected);
                BtWeekView.setBackgroundResource(R.drawable.bg_button_light_style_normal);
                BtMonthView.setTextColor(getResources().getColor(R.color.black));
                BtWeekView.setTextColor(getResources().getColor(R.color.moderate_grey));
            }
        });

        BtWeekView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarLayout.shrink();
                BtMonthView.setBackgroundResource(R.drawable.bg_button_light_style_normal);
                BtWeekView.setBackgroundResource(R.drawable.bg_button_light_style_selected);
                BtMonthView.setTextColor(getResources().getColor(R.color.moderate_grey));
                BtWeekView.setTextColor(getResources().getColor(R.color.black));
            }
        });
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

        calendarView.setOnViewChangeListener(new CalendarView.OnViewChangeListener() {
            @Override
            public void onViewChange(boolean isMonthView) {

            }
        });

        calendarView.setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                setChangedMonth(year, month);
            }
        });
    }

    private void setChangedMonth(int year, int month) {
//        TextView tvSelectedDate = rootView.findViewById(R.id.id_tv_date_calendar);
        TextView tvSelectedMonth = rootView.findViewById(R.id.id_tv_month_calendar);
        String monthData = year +" "+new DateFormatSymbols().getMonths()[month-1].toUpperCase();
        tvSelectedMonth.setText(monthData);
//        if (month!=actualCurrentMonth){
//            tvSelectedMonth.setBackgroundResource(R.drawable.bg_transparent_rounded_corner_view);
//            tvSelectedDate.setBackgroundResource(R.drawable.bg_transparent_rounded_corner_view);
//        }
//        else{
//            tvSelectedMonth.setBackgroundResource(R.drawable.bg_light_red_rounded_corner_view);
//            if (calendarView.getCurDay()!=1){
//                tvSelectedDate.setBackgroundResource(R.drawable.bg_transparent_rounded_corner_view);
//            }
//            else{
//                tvSelectedDate.setBackgroundResource(R.drawable.bg_light_red_rounded_corner_view);
//            }
//        }
//        tvSelectedDate.setText("1");
    }

    private void setTvSelectedDate() {
//        TextView tvSelectedDate = rootView.findViewById(R.id.id_tv_date_calendar);
//        tvSelectedDate.setBackgroundResource(R.drawable.bg_light_red_rounded_corner_view);
        int dateSelected = calendarView.getCurDay();
        if (calendarView.getSelectedCalendar().isAvailable()) {
            // user reselected some date
            if (!calendarView.getSelectedCalendar().isCurrentDay()){
                // selected day is not current day
                dateSelected = calendarView.getSelectedCalendar().getDay();
//                tvSelectedDate.setBackgroundResource(R.drawable.bg_transparent_rounded_corner_view);
            } // else selected day is current day
        }
//        tvSelectedDate.setText(String.valueOf(dateSelected));
    }

    public void setTvSelectedMonth() {
        TextView tvSelectedMonth = rootView.findViewById(R.id.id_tv_month_calendar);
//        tvSelectedMonth.setBackgroundResource(R.drawable.bg_light_red_rounded_corner_view);
        int yearSelected = calendarView.getCurYear();
        int monthSelected = calendarView.getCurMonth();
        if (calendarView.getSelectedCalendar().isAvailable()) {
            // user reselected some month
            if (calendarView.getSelectedCalendar().getMonth()!=actualCurrentMonth) {
                // selected month is not current month
                monthSelected = calendarView.getSelectedCalendar().getMonth();
                yearSelected = calendarView.getSelectedCalendar().getYear();
//                tvSelectedMonth.setBackgroundResource(R.drawable.bg_transparent_rounded_corner_view);
            } // else selected day is current day
        }
        String monthData = yearSelected +" "+new DateFormatSymbols().getMonths()[monthSelected - 1].toUpperCase();
        tvSelectedMonth.setText(monthData);
    }

    private void setTvTodayDate() {
        TextView tvTodayDate = rootView.findViewById(R.id.id_tv_today_date);
        int monthToday = calendarView.getCurMonth();
        String month = new DateFormatSymbols().getMonths()[monthToday-1].toUpperCase();
        tvTodayDate.setText(calendarView.getCurDay() +" "+month+" "+calendarView.getCurYear());
    }
}