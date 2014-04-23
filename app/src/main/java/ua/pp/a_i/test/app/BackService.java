package ua.pp.a_i.test.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BackService extends Service {
    Toaster toaster;
    public BackService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        toaster=new Toaster();
        toaster.run();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        toaster.interrupt();
        return super.stopService(name);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class Toaster extends Thread{
        @Override
        public void run() {
            while(true) {
                try {
                    Log.i("Service","Running");
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){

                }
            }
        }
    }
}
