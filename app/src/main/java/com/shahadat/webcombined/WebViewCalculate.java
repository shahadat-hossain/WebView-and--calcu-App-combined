package com.shahadat.webcombined;

import android.content.Context;

/**
 * Created by shaha on 8/7/2017.
 */

public class WebViewCalculate {


    String firstVal="";
    String secondVal="";
    Double result;
    String res;
    boolean flag=false;
    String operatorFromJS;
    WebViewActivity webViewActivity;

    public WebViewCalculate(Context c) {

        webViewActivity=(WebViewActivity)c;

    }

    @android.webkit.JavascriptInterface
    public void addNum(String value) {

        if(flag){
            secondVal+=value;
        }
        else
            firstVal+=value;


    }
    @android.webkit.JavascriptInterface
    public void addOperator(String operator) {
        operatorFromJS = operator;
        flag = true;

    }

    @android.webkit.JavascriptInterface
    public String getResult(){

        switch (operatorFromJS){
            case "+":
                result=Double.valueOf(firstVal)+Double.valueOf(secondVal);
                break;
            case "-":
                result=Double.valueOf(firstVal)-Double.valueOf(secondVal);
                break;
            case "×":
                result=Double.valueOf(firstVal)*Double.valueOf(secondVal);
                break;
            case "÷":
                result=Double.valueOf(firstVal)/Double.valueOf(secondVal);
                break;


        }
        res=result.toString();
        firstVal="";
        secondVal="";
        flag=false;
        return res;
    }
}
