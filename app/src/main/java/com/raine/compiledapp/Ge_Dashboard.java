package com.raine.compiledapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ge_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ge_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onBackClick(View view) {
        finish();
    }

    public void onGe1Click(View view) {
        Intent intent = new Intent(this, GE1.class);
        startActivity(intent);
    }

    public void onGe2Click(View view) {
        Intent intent = new Intent(this, GE2.class);
        startActivity(intent);
    }

    public void onGe3Click(View view) {
        Intent intent = new Intent(this, GE3.class);
        startActivity(intent);
    }

    public void onGe4Click(View view) {
        Intent intent = new Intent(this, GE4.class);
        startActivity(intent);
    }

    public void onGe5Click(View view) {
        Intent intent = new Intent(this, GE5.class);
        startActivity(intent);
    }
    public void onGe6Click(View view) {
        Intent intent = new Intent(this, GE6.class);
        startActivity(intent);
    }


    public void onGe7Click(View view) {
        Intent intent = new Intent(this, GE7.class);
        startActivity(intent);
    }

    public void onGe8Click(View view) {
        Intent intent = new Intent(this, GE8.class);
        startActivity(intent);
    }

    public void onGe9Click(View view) {
        Intent intent = new Intent(this, GE9.class);
        startActivity(intent);
    }
}