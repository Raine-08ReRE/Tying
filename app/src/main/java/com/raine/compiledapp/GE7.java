package com.raine.compiledapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GE7 extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rate;
    Button click, close;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ge7);
// object creation of alertDialogBuilder
        alertDialogBuilder = new AlertDialog.Builder(this);
        ratingBar = findViewById(R.id.ratingBar);
        rate = findViewById(R.id.tvResultGE7);
        click = findViewById(R.id.btnClickGE7);
        close = findViewById(R.id.btnCloseGE7);

        showRating();
        closeApplication();
    }

    public void showRating(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(ratingBar.getRating() >= 3){
                    rate.setTextColor(Color.GREEN);
                }else{
                    rate.setTextColor(Color.RED);
                }
                rate.setText("Rate: " + ratingBar.getRating());
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Rate: " + ratingBar.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void closeApplication(){
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder.setTitle("Warning Message!")
                        .setMessage("Do you want to close the Application?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // once the Yes is selected it will close the application using
                                // this pre-defined method named finish() in android
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // once the No is selected it will simply close/cancel the
                                // dialogInterface
                                dialogInterface.cancel();
                            }
                        })
                        // this will sets whether this dialog is cancelable or not, by default is TRUE
                        .setCancelable(false);
                // display our dialog builder
                alertDialogBuilder.show();
            }
        });
    }

    // this is a pre-defined method in android that we can override and put some algorithm and it will be called once back button is clicked
    @Override
    public void onBackPressed() {
        alertDialogBuilder.setTitle("Warning Message!")
                .setMessage("Do you want to close the Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }

                })
                .setCancelable(false);
        alertDialogBuilder.show();

        // Call super.onBackPressed() to ensure the default behavior is executed
        super.onBackPressed();
    }

}


