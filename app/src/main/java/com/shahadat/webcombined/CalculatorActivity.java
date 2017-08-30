package com.shahadat.webcombined;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    //Assigning variable for each content
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button point;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button clear;
    private Button delete;
    private Button equal;
    private Button save;
    private Button reset;
    private Button memoryplus;
    private Button memoryminus;
    private Button memory;
    private TextView result;
    private TextView temp;
    private TextView control;
    private final char Addition='+';
    private final char Subtraction='-';
    private final char Multipliction='*';
    private final char Division='/';
    private double value1;
    private double value2;
    private double valFinal;
    private char Action;
    private String resultfromactivity;
    SharedPreferences calPref;
    int REQ_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //On create means when app will run. So call those function which I want to show or do activity on run the app....
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setupViews();

        calPref=getPreferences(MODE_PRIVATE);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.setText(control.getText().toString() + "0");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()==0){
                    control.setText( "0.");
                    point.setClickable(false);
                }
                else{
                    control.setText(control.getText().toString() + ".");
                    point.setClickable(false);
                }


            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()==0){

                    Context context = getApplicationContext();
                    CharSequence text = "No Value..Input a Value..";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    Action=Addition;
                    value1= Double.parseDouble(control.getText().toString());
                    result.setText(String.valueOf(value1) + "+");
                    control.setText(null);
                    point.setClickable(true);

                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()==0){
                    Context context = getApplicationContext();
                    CharSequence text = "No Value..Input a Value..";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{

                    Action=Subtraction;
                    value1= Double.parseDouble(control.getText().toString());
                    result.setText(String.valueOf(value1) + "-");
                    control.setText(null);
                    point.setClickable(true);
                }

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()==0){
                    Context context = getApplicationContext();
                    CharSequence text = "No Value..Input a Value..";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{

                    Action=Multipliction;
                    value1= Double.parseDouble(control.getText().toString());
                    result.setText(String.valueOf(value1) + "×");
                    control.setText(null);
                    point.setClickable(true);
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()==0){
                    Context context = getApplicationContext();
                    CharSequence text = "No Value..Input a Value..";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{

                    Action=Division;
                    value1= Double.parseDouble(control.getText().toString());
                    result.setText(String.valueOf(value1) + "÷");
                    control.setText(null);
                    point.setClickable(true);

                }

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()!=0){
                    compute();
                    control.setText(null);
                    point.setClickable(true);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "No Value..Input a Value..";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()>0){
                    CharSequence name=control.getText().toString();
                    control.setText(name.subSequence(0, name.length()-1));//clear one by one char
                    point.setClickable(true);
                }
                else if(result.getText().length()>0){
                    CharSequence character=result.getText().toString();
                    result.setText(character.subSequence(0, character.length()-1));
                    point.setClickable(true);
                }
                else{
                    value1=Double.NaN;
                    value2=Double.NaN;
                    control.setText(null);
                    result.setText(null);
                    temp.setText(null);
//                   equaltext.setText(null);
                    point.setClickable(true);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1=Double.NaN;
                value2=Double.NaN;
                control.setText(null);
                result.setText(null);
                temp.setText(null);
//                equaltext.setText(null);
                point.setClickable(true);
            }
        });
        memoryplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=calPref.getString("keyVal","");
                if(value!=""){
                    valFinal=Double.parseDouble(calPref.getString("keyVal",""));
                    valFinal=valFinal+1.0;
                    temp.setText(String.valueOf(valFinal));
                    value1=valFinal;
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "No Value in memory";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
        memoryminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=calPref.getString("keyVal","");

                if(value!=""){
                    valFinal=Double.parseDouble(calPref.getString("keyVal",""));
                    valFinal=valFinal-1.0;

                }


                else{
                    Context context = getApplicationContext();
                    CharSequence text = "No Value in memory";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                temp.setText(String.valueOf(valFinal));


            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String show= calPref.getString("keyVal","");
                if(show!=""){

                    control.setText(show);
                    result.setText(null);
                    value1=Double.parseDouble(show);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "No Value in memory";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

            }
        });

    }

    private void setupViews(){
        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        zero=(Button)findViewById(R.id.btn0);
        point=(Button)findViewById(R.id.btnPoint);
        add=(Button)findViewById(R.id.btnAdd);
        sub=(Button)findViewById(R.id.btnSub);
        mul=(Button)findViewById(R.id.btnMul);
        div=(Button)findViewById(R.id.btnDiv);
        clear=(Button)findViewById(R.id.btnClear);
        delete=(Button)findViewById(R.id.btnDelete);
        equal=(Button)findViewById(R.id.btnEqual);
        save=(Button)findViewById(R.id.btnSave);
        reset=(Button)findViewById(R.id.btnReset);
        memoryplus=(Button)findViewById(R.id.btnMplus);
        memoryminus=(Button)findViewById(R.id.btnMminus);
        memory=(Button)findViewById(R.id.btnMemory);
        result=(TextView)findViewById(R.id.tvResult);
        control=(TextView)findViewById(R.id.tvControl);
        temp=(TextView)findViewById(R.id.tvTemp);

    }
    private void compute(){
        if(!Double.isNaN(value1)){
            value2=Double.parseDouble(control.getText().toString());


            Intent intent = new Intent(CalculatorActivity.this, CalculateActivity.class);
            intent.putExtra("value1", value1);
            intent.putExtra("value2", value2);
            intent.putExtra("operation", Action);
            startActivityForResult(intent,REQ_CODE);

        }
        else{
            value1=Double.parseDouble(control.getText().toString());
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE&&resultCode==RESULT_OK&&data!=null){
            resultfromactivity=data.getStringExtra("result");
//          value1=Double.parseDouble(resultfromactivity);
            temp.setText("="+resultfromactivity);
            control.setText(resultfromactivity);
        }
    }
    public void onSave(View view) {
        if(!Double.isNaN(value1)){
            String lastResult=control.getText().toString();
            SharedPreferences.Editor editor=calPref.edit();
            editor.putString("keyVal",lastResult);
            editor.commit();
            Context context = getApplicationContext();
            CharSequence text = "Value Saved";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "No Value Saved";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void onReset(View view) {
        SharedPreferences.Editor editor=calPref.edit();
        editor.clear();
        editor.commit();
        Context context = getApplicationContext();
        CharSequence text = "Value Removed";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
