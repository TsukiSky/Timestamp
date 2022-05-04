package com.siqi.timestamp.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.core.content.ContextCompat;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;
import com.siqi.timestamp.R;

public class TopCalendarMonthView extends MonthView {

    Paint selectedBlockPaint = new Paint();
    Paint todayBlockPaint = new Paint();
    Paint textPaint = new Paint();

    public TopCalendarMonthView(Context context) {
        super(context);
        selectedBlockPaint.setStyle(Paint.Style.STROKE);
        selectedBlockPaint.setAntiAlias(true);
        selectedBlockPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.light_red));
        selectedBlockPaint.setStrokeWidth(6);
        todayBlockPaint.setStyle(Paint.Style.FILL);
        todayBlockPaint.setAntiAlias(true);
        todayBlockPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.light_red));
        textPaint.setTextSize(46);
        textPaint.setFakeBoldText(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        if (!calendar.isCurrentDay()){
            canvas.drawCircle(x+mItemWidth/2, y+mItemHeight/2, mItemHeight/2, selectedBlockPaint);
        }
        return true;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        if (calendar != null) {
            if (calendar.isCurrentDay()) {
                // current day
//                int blockLeft = x + (mItemWidth - mItemHeight) / 2;
//                int blockRight = x + (mItemWidth - mItemHeight) / 2 + mItemHeight;
//                RectF block = new RectF(blockLeft, y, blockRight, y + mItemHeight);
//                canvas.drawRoundRect(block, 24f, 24f, todayBlockPaint);
                if (isSelected) {
                    canvas.drawCircle(x + mItemWidth / 2, y + mItemHeight / 2, mItemHeight / 2, todayBlockPaint);
                    textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
                }
                else{
                    textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.light_red));
                }
            }

//            if (isSelected && calendar.isCurrentDay()) {
//                textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
//            } else {
            else {
                int round_radius = mItemHeight / 2;
                if (isSelected) {
                    // not current day but selected
                    textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.black));
                } else {
                    // not current day and not selected
                    if (calendar.isCurrentMonth()) {
                        // is current month
                        textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.black));
                    } else {
                        // not even current month
                        textPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.light_grey));
                    }
                }
            }
            canvas.drawText(String.valueOf(calendar.getDay()), x + mItemWidth/2, mTextBaseLine + y, textPaint);
        }
    }
}
