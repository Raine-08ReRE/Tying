package com.raine.compiledapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    private ImageView imgMp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

    }

    public void onBackClick(View view) {
        finish();
    }

    public void onimgMp2Click(View view) {
        Intent intent = new Intent(this, SCalculator.class);
        startActivity(intent);
    }

    public void onimgMp3Click(View view) {
        Intent intent = new Intent(this, GCalculator.class);
        startActivity(intent);
    }

    public void onimgMp5Click(View view) {
        Intent intent = new Intent(this, CCalculator.class);
        startActivity(intent);
    }
}