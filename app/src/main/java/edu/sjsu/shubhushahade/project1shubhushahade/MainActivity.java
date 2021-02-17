package edu.sjsu.shubhushahade.project1shubhushahade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText PrincipleAmt;
    private EditText Result;
    private EditText RatePercent;

    private TextView Principle;
    private TextView loanTerm;
    private TextView interestRate;

    private RadioButton y15;
    private RadioButton y20;
    private RadioButton y30;

    private Button calculate;
    private Button uninstall;

    private CheckBox checkBox;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrincipleAmt = findViewById(R.id.PrincipleAmt);
        Result = findViewById(R.id.Result);
        RatePercent= findViewById(R.id.RatePercent);
        Principle= findViewById(R.id.Principle);
        loanTerm = findViewById(R.id.loanTerm);
        interestRate = findViewById(R.id.interestRate);
        y15 = findViewById(R.id.y15);
        y20 = findViewById(R.id.y20);
        y30 = findViewById(R.id.y30);
        calculate = findViewById(R.id.Calculate);
        uninstall= findViewById(R.id.Uninstall);
        checkBox= findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);
    }
}