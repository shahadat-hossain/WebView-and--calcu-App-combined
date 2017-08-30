package com.shahadat.webcombined;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by shaha on 8/6/2017.
 */

public class ConnectionDetector {

    Context context;

    public ConnectionDetector(Context context) {
        this.context=context;
    }
    public boolean isConnected(){
        ConnectivityManager connection=(ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connection!=null){
            NetworkInfo info=connection.getActiveNetworkInfo();
            if(info!=null){
                if(info.getState()==NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }
}
