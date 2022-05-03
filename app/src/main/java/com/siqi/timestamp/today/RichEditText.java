package com.siqi.timestamp.today;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class RichEditText extends androidx.appcompat.widget.AppCompatEditText {

    public RichEditText(Context context) {
        super(context);
    }

    public RichEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RichEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    
    public final String BOLD = "BOLD";
    public final String UNDERLINE = "UNDERLINE";
    public final String ITALIC = "ITALICD";
    public final String FORE_COLOR = "FORE_COLOR";
    public final String BACK_COLOR = "BACK_COLOR";

    String wholeText = this.getText().toString();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(wholeText);


    // get spanStyle
    private Object getSpanstyle(String type, int color){
        switch (type){
            case BOLD:
                return new StyleSpan(Typeface.BOLD);
            case ITALIC:
                return new StyleSpan(Typeface.ITALIC);
            case UNDERLINE:
                return new UnderlineSpan();
            case FORE_COLOR:
                return new ForegroundColorSpan(color);
            case BACK_COLOR:
                return new BackgroundColorSpan(color);
            default:
                return new StyleSpan(Typeface.NORMAL);

        }
    }

    // set spanStyle
    public void setSpanStyle(Object spanStyle){

        int start = this.getSelectionStart();
        int end = this.getSelectionEnd();

        spannableStringBuilder.setSpan(spanStyle , start, end, 0);
        this.setText(spannableStringBuilder);

    }

    // main method for setting text style
    public void editRichText(String type, int color){
        setSpanStyle(getSpanstyle(type,color));
    }

    public void editRichText(String type){
        setSpanStyle(getSpanstyle(type,Color.BLACK));//todo: in case night mode, change to r.id
    }
}
