package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.TypefaceCompatApi28Impl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button victimsPerspective;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        victimsPerspective = (Button)findViewById(R.id.victim);
        exit = (Button)findViewById(R.id.exit);

        victimsPerspective.setOnClickListener( v->{
            Intent intent = new Intent(MainActivity.this, VictimActivity.class);
            startActivity(intent);
        });

        exit.setOnClickListener( v->{
            System.exit(0);
        });
    }
}