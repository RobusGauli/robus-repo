package robus.com.robsasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {

    ProgressBar progressBar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new MyAsync().execute();

    }


    class MyAsync extends AsyncTask<Void,Integer,Bitmap>{


        @Override
        protected void onPreExecute() {
            progressBar = (ProgressBar)findViewById(R.id.progressBar2);

            imageView = (ImageView)findViewById(R.id.imageView);


        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap bitmap = null;
            try {
                URL url = new URL("https://pixabay.com/static/uploads/ec/2015/07/25/12-31-28-217_250x250.jpg");
                HttpURLConnection httpURLConnection  = (HttpURLConnection) url.openConnection();
                int status = httpURLConnection.getResponseCode();

                InputStream inputStream = httpURLConnection.getInputStream();
                 bitmap = BitmapFactory.decodeStream(inputStream);

                ///call publish progress from background thread and pass in integer value to onProgressUpdate() method of AysncTask()..

                publishProgress();



            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressBar.setVisibility(View.INVISIBLE);
            imageView.setImageBitmap(bitmap);

        }
    }
}
