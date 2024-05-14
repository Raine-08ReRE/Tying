package com.raine.compiledapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CCalculator extends AppCompatActivity {

    private CheckBox vanillaCheckBox, teaCheckBox, smoresCheckBox, mochaCheckBox;
    private RadioGroup discountRadioGroup;
    private Button computeButton, clearAllButton;
    private TextView subtotalTextView, discountTextView, netAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ccalculator);

        // Initialize views
        vanillaCheckBox = findViewById(R.id.Vanilla);
        teaCheckBox = findViewById(R.id.Tea);
        smoresCheckBox = findViewById(R.id.Smores);
        mochaCheckBox = findViewById(R.id.mocha);
        discountRadioGroup = findViewById(R.id.discountRadioGroup);
        computeButton = findViewById(R.id.Compute);
        clearAllButton = findViewById(R.id.CLearALL);
        subtotalTextView = findViewById(R.id.Subtotal);
        discountTextView = findViewById(R.id.Discount);
        netAmountTextView = findViewById(R.id.NetAmmount);

        // Set default discount
        discountRadioGroup.check(R.id.NoDiscount);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
            }
        });

        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });
    }

    private void compute() {
        double subtotal = 0;

        if (vanillaCheckBox.isChecked()) {
            subtotal += 150;
            showToast("Caffe Vanilla Frappuccino selected");
        }
        if (teaCheckBox.isChecked()) {
            subtotal += 190;
            showToast("Green Tea Creme Frappuccino selected");
        }
        if (smoresCheckBox.isChecked()) {
            subtotal += 199;
            showToast("S'mores Frappuccino selected");
        }
        if (mochaCheckBox.isChecked()) {
            subtotal += 130;
            showToast("Mocha Green Tea Creme Frappuccino selected");
        }

        subtotalTextView.setText(String.format("%.2f", subtotal));

        double discountPercent = getDiscountPercent();
        double discountAmount = (subtotal * discountPercent) / 100;
        discountTextView.setText(String.format("%.2f", discountAmount));

        double netAmount = subtotal - discountAmount;
        netAmountTextView.setText(String.format("%.2f", netAmount));
    }

    private void clearAll() {
        vanillaCheckBox.setChecked(false);
        teaCheckBox.setChecked(false);
        smoresCheckBox.setChecked(false);
        mochaCheckBox.setChecked(false);
        discountRadioGroup.check(R.id.NoDiscount);
        subtotalTextView.setText("0.00");
        discountTextView.setText("0.00");
        netAmountTextView.setText("0.00");
    }

    private double getDiscountPercent() {
        int checkedRadioButtonId = discountRadioGroup.getCheckedRadioButtonId();

        if (checkedRadioButtonId == R.id.Five) {
            showToast("5% discount selected");
            return 5;
        } else if (checkedRadioButtonId == R.id.Ten) {
            showToast("10% discount selected");
            return 10;
        } else if (checkedRadioButtonId == R.id.Fifteen) {
            showToast("15% discount selected");
            return 15;
        } else if (checkedRadioButtonId == R.id.NoDiscount) {
            showToast("No discount selected");
            return 0;
        } else {
            return 0;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onBackClick(View view) {
        finish();
    }
}