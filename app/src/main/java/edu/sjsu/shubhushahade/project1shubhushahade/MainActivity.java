package edu.sjsu.shubhushahade.project1shubhushahade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText PrincipleAmt;
    private EditText Result;

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

    float intRate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrincipleAmt = (EditText) findViewById(R.id.PrincipleAmt);
        Result = findViewById(R.id.Result);
        Principle = findViewById(R.id.Principle);
        loanTerm = findViewById(R.id.loanTerm);
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

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                intRate = progress;
                interestRate.setText("Interest rate: " + (float) progress / 10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                interestRate.setText("Interest rate: " + (float) intRate / 10);
            }
        });
    }

    public void Calculate(View view){
        float T = 0;
        float M = 0;
        float N = 12;
        if (PrincipleAmt.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return; }
        float P = Float.parseFloat(PrincipleAmt.getText().toString());
        if (checkBox.isChecked() == true){
            T = (float) ((0.1/100) * P);
        }
        else if (checkBox.isChecked() == false){
            T = 0;
        }

        if (intRate > 0){
            M = P/N * T;
        }
        else {

        }

        Result.setText(String.valueOf(M));
    }

}