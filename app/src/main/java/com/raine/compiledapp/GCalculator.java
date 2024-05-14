package com.raine.compiledapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GCalculator extends AppCompatActivity {

    public double SemGrade;
    public String PtEqu;
    public String Remarks;
    public String CRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gcalculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickCompute(View view) {
        EditText etSname = findViewById(R.id.etSName);
        EditText etprelim = findViewById(R.id.etPrelim);
        EditText etmidterm = findViewById(R.id.etMidterm);
        EditText etfinals = findViewById(R.id.etFinals);

        TextView txtsname = findViewById(R.id.txtSName);
        TextView txtsemgrade = findViewById(R.id.txtSemGrade);
        TextView txtptequ = findViewById(R.id.txtPtEqu);
        TextView txtremarks = findViewById(R.id.txtRemarks);

        txtsname.setText(" " + etSname.getText().toString());
        txtsemgrade.setText(" " + etSname.getText().toString());


        double prelim = Double.parseDouble(etprelim.getText().toString());
        double midterm = Double.parseDouble(etmidterm.getText().toString());
        double finals = Double.parseDouble(etfinals.getText().toString());

        SemGrade = (0.25 * prelim) + (0.25 * midterm) +  (0.50 * finals);
        txtsemgrade.setText(" " + SemGrade);

        PtEquivalent();
        txtptequ.setText(" " + PtEqu);

        Remarkss(txtremarks);
        txtremarks.setText(" "  + Remarks );
    }




    public void PtEquivalent(){
        if(SemGrade == 100 ) {
            PtEqu = "1.00";
        }
        else if (SemGrade >= 95  && SemGrade <= 99) {
            PtEqu = "1.50";
        }
        else if (SemGrade >= 90  && SemGrade < 94) {
            PtEqu = "2.00";
        }
        else if (SemGrade >= 85  && SemGrade < 89) {
            PtEqu = "2.50";
        }
        else if (SemGrade >= 80  && SemGrade < 84) {
            PtEqu = "3.00";
        }
        else if (SemGrade >= 75  && SemGrade < 79) {
            PtEqu = "3.50";
        }

        else {
            PtEqu = "5.00";
        }
    }

    public void Remarkss(TextView txtremarks) {
        switch (PtEqu) {
            case "1.00":
            case "1.50":
            case "2.00":
            case "2.50":
            case "3.00":
            case "3.50":
                Remarks = "Pass";
                break;

            default:
                Remarks = "Fail";
                break;
        }

        if(Remarks.equals("Pass")){
            txtremarks.setTextColor(Color.GREEN);
        } else {
            txtremarks.setTextColor(Color.RED);
        }

    }
    public void onCLickNewEntry (View view){
        EditText etSname = findViewById(R.id.etSName);
        EditText etprelim = findViewById(R.id.etPrelim);
        EditText etmidterm = findViewById(R.id.etMidterm);
        EditText etfinals = findViewById(R.id.etFinals);
        TextView txtsname = findViewById(R.id.txtSName);
        TextView txtsemgrade = findViewById(R.id.txtSemGrade);
        TextView txtptequ = findViewById(R.id.txtPtEqu);
        TextView txtremarks = findViewById(R.id.txtRemarks);


        etSname.setText("");
        etprelim.setText("");
        etmidterm.setText("");
        etfinals.setText("");


        txtsname.setText("  ");
        txtsemgrade.setText(" ");
        txtptequ.setText(" ");
        txtremarks.setText(" ");

        SemGrade = 0;
        PtEqu = "";
        Remarks = "";
        CRemarks = "";

        txtremarks.setTextColor(Color.BLACK);




    }
}