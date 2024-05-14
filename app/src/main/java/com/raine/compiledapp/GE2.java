package com.raine.compiledapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GE2 extends AppCompatActivity {

    EditText name;
    Button click;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ge2);

        name = findViewById(R.id.etNameGE2);
        click = findViewById(R.id.btnClickGE2);
        showResult();
    }

    public void showResult(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast = Toast.makeText(getApplicationContext(),
                        "Hello " + name.getText().toString() + "! \nWelcome to Android Development!",Toast.LENGTH_SHORT);
                view = toast.getView();
                // gets the actual oval background of the Toast then sets the colour filter
                view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                // set layout of toast
                toast.setGravity(Gravity.CENTER, 0, 0);
                // display the toast
                toast.show();
            }
        });
    }

    public void onBackClick(View view) {
        finish();
    }
}
