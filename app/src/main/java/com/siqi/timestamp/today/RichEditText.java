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
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class RichEditText extends androidx.appcompat.widget.AppCompatEditText {

    public RichEditText(Context context) {
        super(context);
    }

    public static final String BOLD = "BOLD";
    public static final String UNDERLINE = "UNDERLINE";
    public static final String ITALIC = "ITALIC";
    public static final String FORE_COLOR = "FORE_COLOR";
    public static final String BACK_COLOR = "BACK_COLOR";


    String wholeText = this.getText().toString();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(wholeText);


    public RichEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RichEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    // type applied states
    boolean isBold = false;
    boolean isItalic = false;
    boolean isUnderlined = false;
    boolean isForecolored = false;
    boolean isBackcolored = false;


    // get spanStyle
    private Object[] getSpanstyle(String type, int color){
        switch (type){
            case BOLD:
                if (isBold){
                    isBold = false;
                    //remove span
                    return new Object[]{0, new StyleSpan(Typeface.BOLD)};
                }
                else {
                    isBold = true;
                    // add span
                    return new Object[]{1, new StyleSpan(Typeface.BOLD)};
                }

            case ITALIC:
                if (isItalic){
                    isItalic = false;
                    return new Object[]{0, new StyleSpan(Typeface.ITALIC)};
                }
                else {
                    isItalic = true;
                    return new Object[]{1, new StyleSpan(Typeface.ITALIC)};
                }

            case UNDERLINE:
                if (isUnderlined){
                    isUnderlined = false;
                    return new Object[]{0, new UnderlineSpan()};
                }
                else {
                    isUnderlined =true;
                    return new Object[]{1, new UnderlineSpan()};
                }

            case FORE_COLOR:
                if (isForecolored){
                    isForecolored = false;
                    return new Object[]{0, new ForegroundColorSpan(Color.BLACK)};
                }
                else {
                    isForecolored = true;
                    return new Object[]{1, new ForegroundColorSpan(color)};
                }

            case BACK_COLOR:
                if (isBackcolored){
                    isBackcolored = false;
                    return new Object[]{0, new BackgroundColorSpan(color)};
                }
                else {
                    isBackcolored = true;
                    return new Object[]{1, new BackgroundColorSpan(color)};
                }

            default:
                return new Object[]{1, new StyleSpan(Typeface.NORMAL)};

        }
    }

    // set spanStyle
    private void setSpanStyle(Object[] spanStyle){

        int start = this.getSelectionStart();
        int end = this.getSelectionEnd();
        if (spanStyle[0].equals(1)){
            Log.i("setSpanStyle_if", String.valueOf(this.length()));
            spannableStringBuilder.setSpan(spanStyle[1] , start, end, 0);
            this.setText(spannableStringBuilder);
        }
        else {
            Log.i("setSpanStyle_else", String.valueOf(start)+String.valueOf(end)+String.valueOf(spanStyle[1] ));
            Object[] spans = getEditableText().getSpans(start,end,spanStyle[1].getClass());
            for (Object span: spans){
                getEditableText().removeSpan(span);
            }

            //Log.i("typesfalse",spannableStringBuilder.getSpans(start,end,null).toString());
        }
    }

    // main method for setting text style
    public void editRichText(String type, int color){
        setSpanStyle(getSpanstyle(type,color));
    }

    public void editRichText(String type){
        //Log.i("isItalic:", String.valueOf(isItalic));
        setSpanStyle(getSpanstyle(type,Color.BLACK));//todo: in case night mode, change to r.id
    }
}
