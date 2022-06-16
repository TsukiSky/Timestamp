package com.siqi.timestamp.calendar.dailyEventCard;

public class DailyTime {
    private final int date;
    private final int hour;
    private final int minute;
    DailyTime(int date, int hour, int minute){
        this.date = date;
        this.hour = hour;
        this.minute = minute;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int duration(DailyTime dailyTime){
        return Math.abs(this.hour*60+this.minute-dailyTime.hour*60-dailyTime.minute);
    }
}
