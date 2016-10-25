package com.makemoji.sbaar.mojilist;

import android.app.Application;
import android.content.Context;

import com.makemoji.keyboard.MMKB;
import com.makemoji.mojilib.Moji;

/**
 * Created by Scott Baar on 12/14/2015.
 */
public class App extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Moji.initialize(this,"YOUR-SDK-KEY-HERE");
        //Moji.setChannel("Channel1");
        //Moji.setUserId("Google ad id here if needed");
        //MMKB.setShareMessage("the message");
        //LeakCanary.install(this);
    }
}
