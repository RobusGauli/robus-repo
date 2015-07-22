package robus.com.simplethreading;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.image);
        //4.create an objject of Mythread and pass that object in Thread constructor

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();


        //5..thats all
        //points to not ** declare internet permission in android manifest






    }

    //1.create a inner class that implements Runnable Interface
    //2. insert a networking code here so that long running operation is done on worker thread
    class MyThread implements Runnable{


        @Override
        public void run() {
            try{
                URL url = new URL("http://cdn.mysitemyway.com/icons-watermarks/simple-black/raphael/raphael_gear-small/raphael_gear-small_simple-black_128x128.png");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                //3.remember post() method of view class allows you to pass a Runnable object in message queue of main thread..and hence u can
                //access UI elements in main thread
                imageView.post(new Runnable() {
                    @Override
                    public void run() {

                        imageView.setImageBitmap(bitmap);
                    }
                });


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}


/*  new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    URL url = new URL("http://cdn.mysitemyway.com/icons-watermarks/simple-black/raphael/raphael_gear-small/raphael_gear-small_simple-black_128x128.png");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {

                            imageView.setImageBitmap(bitmap);
                        }
                    });


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();*/






