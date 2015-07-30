package robus.com.robshandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Handler handler;
    Thread thread;
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);

            }
        };


        new Thread(new Runnable() {
            @Override
            public void run() {


                for(int i=0;i<10000;i++){
                    Message message = Message.obtain();
                    message.arg1 = i;
                    handler.sendMessage(message);

                }

            }
        }).start();



    }


}
