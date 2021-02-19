package edu.sjsu.shubhushahade.project1shubhushahade;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText PrincipleAmt;
    private EditText Result;

    private TextView Principle;
    private TextView loanTerm;
    private TextView interestRate;

    private RadioGroup loanOptions;
    private RadioButton y15;
    private RadioButton y20;
    private RadioButton y30;

    private Button calculate;
    private Button uninstall;

    private CheckBox checkBox;
    private SeekBar seekBar;

    float intRate = 0;
    int years = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrincipleAmt = (EditText) findViewById(R.id.PrincipleAmt);
        Result = findViewById(R.id.Result);
        Principle = findViewById(R.id.Principle);
        loanTerm = findViewById(R.id.loanTerm);
        loanOptions = (RadioGroup) findViewById(R.id.loan_term_options);
        interestRate = findViewById(R.id.interestRate);
        y15 = (RadioButton) findViewById(R.id.y15);
        y20 = (RadioButton) findViewById(R.id.y20);
        y30 = (RadioButton) findViewById(R.id.y30);
        calculate = findViewById(R.id.Calculate);
        uninstall = findViewById(R.id.Uninstall);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);
        setSeekBar();
        }


    public void setSeekBar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                intRate = progress;
                interestRate.setText("Interest rate: " + (float) intRate/10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                intRate = intRate/10;
                interestRate.setText("Interest rate: " + (float) intRate);
            }
        });
    }

    public int setLoanTerm(){
        y15.setOnClickListener(v -> years = 15);
        y20.setOnClickListener(v -> years = 20);
        y30.setOnClickListener(v -> years = 30);

        return years;
    }

    public void Calculate(View view){
        float T = 0;
        float M;
        float N = setLoanTerm() * 12;
        if (PrincipleAmt.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return; }
        float P = Float.parseFloat(PrincipleAmt.getText().toString());
        if (checkBox.isChecked()){
            T = (float) ((0.1/100) * P);
        }
        else if (!checkBox.isChecked()){
            T = 0;
        }

        if (intRate > 0){
            float J = intRate/12;
            M = (float) ((P * J)/(1 - Math.pow((1 + J), - N) ) + T);
        }
        else {
            M = (P/N) + T;
        }
        Result.setText(String.valueOf(M));
    }

}