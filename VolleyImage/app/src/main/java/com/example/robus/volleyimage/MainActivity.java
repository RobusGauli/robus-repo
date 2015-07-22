package com.example.robus.volleyimage;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;


public class MainActivity extends ActionBarActivity {
        NetworkImageView networkImageView;
    RequestQueue requestQueue;
    ImageLoader imageLoader;
    String url;
    String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         networkImageView = (NetworkImageView)findViewById(R.id.networkimage);

      //  requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
       // url = "http://192.168.1.6/musicstore/webapi/albums";
       // Cache.Entry entry = requestQueue.getCache().get(url);
//        final TextView textView = (TextView)findViewById(R.id.textView);


        String imageurl  ="http://hdwallpapersfit.com/wp-content/uploads/2015/04/vertical-hd-wallpaper.jpg";

        imageLoader = VolleySingleton.getInstance(this).getImageLoader();
        networkImageView.setImageUrl(imageurl,imageLoader);

       /* StringRequest stringRequest = new StringRequest(url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                         textView.setText(response);
//                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"wrror loading",Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(stringRequest);*/


    }

}

