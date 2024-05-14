package com.raine.compiledapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GE4 extends AppCompatActivity {

    EditText username, password;
    TextView result;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ge4);

        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);
        showResult();
    }

    public void showResult(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("papsi") &&
                        password.getText().toString().equals("android")){
                    result.setText("Welcome " + username.getText().toString() +"!");
                    // this will set the result text color into GREEN
                    result.setTextColor(Color.GREEN);
                    clearEntry();

                }else{
                    result.setText("Username and Password does not exist!");
                    // this will set the result text color into RED
                    result.setTextColor(Color.RED);
                    clearEntry();

                }
            }
        });
    }

    public void clearEntry(){
        result.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }

    public void onBackClick(View view) {
        finish();
    }
}

