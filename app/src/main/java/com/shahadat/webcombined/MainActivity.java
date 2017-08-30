package com.shahadat.webcombined;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button check;
    ConnectionDetector cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check=(Button)findViewById(R.id.btnCheck);
        cd=new ConnectionDetector(this);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cd.isConnected()){
                    Toast.makeText(MainActivity.this, "Connected",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this, WebViewActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Not Connected",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this, CalculatorActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
