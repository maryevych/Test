package ua.pp.a_i.test.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent= new Intent(this,BackService.class);
    }

    public void startServ(View view){
        this.startService(intent);
    }

    public void stopServ(View view){
        stopService(intent);
    }

}
