package com.adolph.jrm.lukouapplication.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Adolph on 16/7/8.
 */
public class SpalshHelper {
    public static SpalshHelper helper;
    public static SpalshHelper getIntance(){
        if(helper == null){
            helper = new SpalshHelper();
        }
        return helper;
    }

    public Boolean isFirstGo(Context context){
        SharedPreferences share = context.getSharedPreferences("isFirst",context.MODE_PRIVATE);
        if(!share.getString("isFirst","").equals("lukou")){
            Editor editor = share.edit();
            editor.putString("isFirst","lukou");
            editor.commit();
            return true;
        }
        return false;
    }
}
