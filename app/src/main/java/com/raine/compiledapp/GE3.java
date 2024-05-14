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

public class GE3 extends AppCompatActivity {

    EditText num1, num2;
    Button sum, ave;
    Toast toast;
    View view;
    double firstNum = 0, secondNum = 0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ge3);

        num1 = findViewById(R.id.etNum1GE3);
        num2 = findViewById(R.id.etNum2GE3);
        sum = findViewById(R.id.btnSumGE3);
        ave = findViewById(R.id.btnAveGE3);

        computeTotal();
    }

    public void computeTotal(){
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this will check if our two EditText has a text value
                if(num1.getText().toString().isEmpty() ||
                        num2.getText().toString().isEmpty()){
                    displayErrorMessage();
                }else{
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    total = firstNum + secondNum;
                    Toast.makeText(getApplicationContext(),
                            "SUM: " + total,Toast.LENGTH_SHORT).show();
                }
            }
        });
        ave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // another way of checking if our two EditText has a text value
                if(num1.getText().length() <= 0 ||
                        num2.getText().length() <= 0 ){
                    displayErrorMessage();
                }else{
                    firstNum = Double.parseDouble(num1.getText().toString());
                    secondNum = Double.parseDouble(num2.getText().toString());
                    total = (firstNum + secondNum) / 2;
                    Toast.makeText(getApplicationContext(),
                            "AVE: " + total,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void displayErrorMessage(){
        toast = Toast.makeText(getApplicationContext(),
                "Please Enter a Number",Toast.LENGTH_SHORT);
        view = toast.getView();
        view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void onBackClick(View view) {
        finish();
    }
}
