package ua.pp.a_i.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


public class MainActivity extends Activity {
    Handler handler;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progress);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setMax(100);
        progressBar.setProgress(0);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle=msg.getData();
                int total=bundle.getInt("total");
                int written=bundle.getInt("written");
                int status=100*written/total;
                progressBar.setProgress(status);
            }
        };
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(this,"http://microsoft.com",new AsyncHttpResponseHandler(){
            @Override
            public void onProgress(int bytesWritten, int totalSize) {
                super.onProgress(bytesWritten, totalSize);
                Bundle bundle=new Bundle();
                bundle.putInt("written",bytesWritten);
                bundle.putInt("total",totalSize);
                Message message=new Message();
                message.setData(bundle);
                handler.sendMessage(message);
            }

            @Override
            public void onStart() {
                super.onStart();
            }
        });
    }
}
