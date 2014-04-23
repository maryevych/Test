package ua.pp.a_i.test.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Yevhen on 16.03.14.
 */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
