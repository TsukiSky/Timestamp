package com.siqi.timestamp.today;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.siqi.timestamp.R;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem_richtext);

        // set tool bar
        View editor_color_bar = findViewById(R.id.richeditor_color_bar);
        View editor_tool_bar = findViewById(R.id.richeditor_tool_bar);


    }


}
