package com.shahadat.webcombined;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {


    private final char Addition='+';
    private final char Subtraction='-';
    private final char Multipliction='*';
    private final char Division='/';
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate2);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("value1", 0);
        double value2 = intent.getDoubleExtra("value2", 0);
        char operation = intent.getCharExtra("operation", '\n');
        tv=(TextView)findViewById(R.id.textView);
        tv.setText(String.valueOf(value1));
        calcuate(value1, value2, operation);
    }


    private double calcuate(double value1, double value2, char operation){


        switch (operation) {
            case Addition:
                value1 = value1 + value2;
                break;
            case Subtraction:
                value1 = value1 - value2;
                break;
            case Multipliction:
                value1 = value1 * value2;
                break;
            case Division:
                value1 = value1 / value2;
                break;

        }


        Intent intent=new Intent(CalculateActivity.this, CalculatorActivity.class);
        intent.putExtra("result",String.valueOf(value1));
        setResult(RESULT_OK,intent);
        finish();

        return value1;

    }
}
