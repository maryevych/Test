package ua.pp.a_i.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;


public class MainActivity extends Activity {
    SeekBar seekBar;
    ImageView image;
    private static boolean visible=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        image=(ImageView)findViewById(R.id.image);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image.setAlpha((float)progress/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClick(View view){
        Animation animation;
        if(visible) {
            animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            visible=false;
        }
        else{
            animation=AnimationUtils.loadAnimation(this,R.anim.fade_in);
            visible=true;
        }
        image.startAnimation(animation);
    }
}
