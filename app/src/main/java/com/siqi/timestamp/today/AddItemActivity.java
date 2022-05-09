package com.siqi.timestamp.today;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.siqi.timestamp.R;

import java.util.concurrent.atomic.AtomicInteger;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem_richtext);

        initView();



    }

    private void initView(){
        AtomicInteger color = new AtomicInteger();
        // save and go back
        ImageView save_add = findViewById(R.id.save_add);
        RichEditText richEditText = findViewById(R.id.richtexteditview_additem);
        save_add.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(TodayFragment.CONTENT,richEditText.getText().toString());
            setResult(RESULT_OK,data);
            finish();
        });

        // set tool bars
        View editor_color_bar = findViewById(R.id.richeditor_color_bar);
        View editor_tool_bar = findViewById(R.id.richeditor_tool_bar);
        editor_color_bar.setVisibility(View.VISIBLE);;
        editor_tool_bar.setVisibility(View.VISIBLE);

        // init toolbar widegts
        ImageView bold = findViewById(R.id.richeditor_toolbar_bold);
        ImageView italic = findViewById(R.id.richeditor_toolbar_italic);
        ImageView underline = findViewById(R.id.richeditor_toolbar_underline);
        ImageView fore_color = findViewById(R.id.richeditor_toolbar_fore_color);
        ImageView back_color = findViewById(R.id.richeditor_toolbar_back_color);


        // init colorbar widegts
        ImageView red = findViewById(R.id.richeditor_color_bar_red);
        ImageView orange = findViewById(R.id.richeditor_color_bar_orange);
        ImageView yellow = findViewById(R.id.richeditor_color_bar_yellow);
        ImageView yellow_green = findViewById(R.id.richeditor_color_bar_yellow_green);
        ImageView green = findViewById(R.id.richeditor_color_bar_green);
        ImageView blue = findViewById(R.id.richeditor_color_bar_blue);
        ImageView cyan = findViewById(R.id.richeditor_color_bar_cyan);
        ImageView blue_purple = findViewById(R.id.richeditor_color_bar_blue_purple);
        ImageView purple = findViewById(R.id.richeditor_color_bar_purple);
        ImageView purple_red = findViewById(R.id.richeditor_color_bar_purple_red);
        ImageView pink = findViewById(R.id.richeditor_color_bar_pink);
        ImageView brown = findViewById(R.id.richeditor_color_bar_brown);
        ImageView gray = findViewById(R.id.richeditor_color_bar_gray);

        red.setOnClickListener(view ->{ color.set(R.color.red);});
        orange.setOnClickListener(view ->{ color.set(R.color.orange);});
        yellow.setOnClickListener(view ->{ color.set(R.color.yellow);});
        yellow_green.setOnClickListener(view ->{ color.set(R.color.yellow_green);});
        green.setOnClickListener(view ->{ color.set(R.color.green);});
        blue.setOnClickListener(view ->{ color.set(R.color.blue);});
        cyan.setOnClickListener(view ->{ color.set(R.color.cyan);});
        blue_purple.setOnClickListener(view ->{ color.set(R.color.blue_purple);});
        purple.setOnClickListener(view ->{ color.set(R.color.purple);});
        purple_red.setOnClickListener(view ->{ color.set(R.color.purple_red);});
        pink.setOnClickListener(view ->{ color.set(R.color.pink);});
        brown.setOnClickListener(view ->{ color.set(R.color.brown);});
        gray.setOnClickListener(view ->{ color.set(R.color.gray);});

        bold.setOnClickListener(view ->{richEditText.editRichText(RichEditText.BOLD);});
        underline.setOnClickListener(view ->{richEditText.editRichText(RichEditText.UNDERLINE);});
        italic.setOnClickListener(view ->{richEditText.editRichText(RichEditText.ITALIC);});
        fore_color.setOnClickListener(view ->{richEditText.editRichText(RichEditText.FORE_COLOR, color.get());});
        back_color.setOnClickListener(view ->{richEditText.editRichText(RichEditText.BACK_COLOR, color.get());});


    }


}
