package com.shahadat.webcombined;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

//@SuppressLint(JavascriptInterface)
public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebViewCalculate webViewCalculate=new WebViewCalculate(this);


        String url="file:///android_asset/index.html";
        WebView web=new WebView(this);


        web.getSettings().setJavaScriptEnabled(true);
        web.addJavascriptInterface(webViewCalculate, "Android");
        //web.addJavascriptInterface(calcObj, "ob");
        web.loadUrl(url);
        setContentView(web);

    }

}
