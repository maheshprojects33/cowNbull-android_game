package com.java.cowandbull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    private TextView rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        rules = findViewById(R.id.tvRules);

        rules.setMovementMethod(new ScrollingMovementMethod());
    }
}