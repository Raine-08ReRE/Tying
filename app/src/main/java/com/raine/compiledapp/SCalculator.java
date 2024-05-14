package com.raine.compiledapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SCalculator extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonDiff, buttonProd, buttonQuo;
    EditText etFirstNumber, etSecondNumber;
    TextView tvResult;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scalculator);

        buttonAdd = findViewById(R.id.btn_add);
        buttonDiff = findViewById(R.id.btn_sub);
        buttonProd = findViewById(R.id.btn_mul);
        buttonQuo = findViewById(R.id.btn_div);

        etFirstNumber = findViewById(R.id.number1);
        etSecondNumber = findViewById(R.id.number2);
        tvResult = findViewById(R.id.txtAnswer);
        buttonAdd.setOnClickListener(this);
        buttonDiff.setOnClickListener(this);
        buttonProd.setOnClickListener(this);
        buttonQuo.setOnClickListener(this);
    }
    public int getEditText(EditText editText){

        if (editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter Number ", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = getEditText(etFirstNumber);
        num2 = getEditText(etSecondNumber);

        int initial = 0;

        if (view.getId() == R.id.btn_add)
        {
            initial = num1 + num2;
            tvResult.setText("Total SUM  = " + initial);
        }
        else if (view.getId() == R.id.btn_sub)
        {
            initial = num1 - num2;
            tvResult.setText("Total DIFFERENCE = " + initial);
        }
        else if (view.getId() == R.id.btn_mul)
        {
            initial = num1 * num2;
            tvResult.setText("Total PRODUCT = " + initial);
        }
        else if (view.getId() == R.id.btn_div)
        {
            if (num2 != 0)
            {
                initial = num1 / num2;
                tvResult.setText("Total QUOTIENT = " + initial);
            }
            else {
                tvResult.setText("Undefined");
                return;
            }
        }

        // Set the result text
        //tvResult.setText("Answer = " + initial);

        if (initial % 2 == 0) {
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        } else {
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    public void onBackClick(View view) {
        finish();
    }
}
