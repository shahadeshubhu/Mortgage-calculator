package edu.sjsu.shubhushahade.project1shubhushahade;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
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

    float intRate = 0;
    private EditText PrincipleAmt;
    private EditText Result;
    private TextView interestRate;
    private CheckBox checkBox;
    private SeekBar seekBar;
    float years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrincipleAmt = (EditText) findViewById(R.id.PrincipleAmt);
        Result = findViewById(R.id.Result);
        TextView principle = findViewById(R.id.Principle);
        TextView loanTerm = findViewById(R.id.loanTerm);
        interestRate = findViewById(R.id.interestRate);
        Button calculate = findViewById(R.id.Calculate);
        //Button uninstall = findViewById(R.id.Uninstall);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        seekBar = findViewById(R.id.seekBar);
        setSeekBar();

        RadioGroup loanOptions = (RadioGroup) findViewById(R.id.loan_term_options);
        loanOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton loanYears =  (RadioButton) group.findViewById(checkedId);
              years = Integer.parseInt(loanYears.getText().toString().substring(0,2));
            }
        });

        /*
        uninstall.setOnClickListener(v -> {
            Intent delete = new Intent(Intent.ACTION_DELETE,
                    Uri.parse("package:" + getPackageName()));
            startActivity(delete);
        });
        */
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

    /*
    public int setLoanTerm(){
        y15.setOnClickListener(v -> years = 15);
        y20.setOnClickListener(v -> years = 20);
        y30.setOnClickListener(v -> years = 30);

        return years;
    }
    */

    /*
    public int getLoanYears(){
        int radioId = loanOptions.getCheckedRadioButtonId();
        RadioButton loanYears = findViewById(radioId);
        loanOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton loanYears = (RadioButton) group.findViewById(checkedId);
            }
        });
        return Integer.parseInt(loanYears.getText().toString().substring(0,2));
    }
    */

    public void Calculate(View view){
        float T = 0;
        float M;
        float N = years * 12;
        double J = 0;
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
            J = intRate/1200;
            M = (float) ((P * J)/(1 - (Math.pow((1 + J), - N))) + T);
        }
        else {
            M = (P/N) + T;
        }
        Result.setText(String.valueOf(M));

    }

    public void Uninstall(View view){
        Button uninstall = findViewById(R.id.Uninstall);
        uninstall.setOnClickListener(v -> {
            Intent delete = new Intent(Intent.ACTION_DELETE,
                    Uri.parse("package:" + getPackageName()));
            startActivity(delete);
        });
    }

}