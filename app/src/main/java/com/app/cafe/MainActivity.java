package com.app.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imgHinh;
    RelativeLayout manhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgHinh = (ImageView) findViewById(R.id.imageViewHinh);
        manhinh = (RelativeLayout) findViewById(R.id.manhinh);
        manhinh.setBackgroundResource(R.drawable.background);
    }
}