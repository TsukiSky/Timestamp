package com.siqi.timestamp.calendar.dailyEventCard;

import com.haibin.calendarview.Calendar;

import java.sql.Time;

public class DailyEvent {
    /* DailyEvent is the event class
    * containing variables:
    *   name: event name
    *   startTime: event starting time
    *   endTime: event ending time
    *   duration: event duration
    * */
    private String name;
    private DailyTime startTime;
    private DailyTime endTime;
    private int duration;

    public DailyEvent(String name, DailyTime start, DailyTime end, int duration){
        this.name = name;
        this.startTime = start;
        this.endTime = end;
        this.duration = duration;
    }

    public void setStartTime(DailyTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(DailyTime endTime) {
        this.endTime = endTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DailyTime getStartTime() {
        return startTime;
    }

    public DailyTime getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }
}
