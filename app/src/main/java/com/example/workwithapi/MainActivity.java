package com.example.workwithapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workwithapi.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView textReq;
    Button button_send;
    private OkHttpClient client;
    String response_text;
   // ExecutorService service = Executors.newFixedThreadPool(5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_send = (Button) findViewById(R.id.button_send);
        textReq = (TextView) findViewById(R.id.textView);
       client = new OkHttpClient();


    }

    public void MakeQvery(View view) {
        RequestMaker requestMaker = new RequestMaker();


       ArrayList<User> list =  requestMaker.GetAllUsers(client);
       Log.d("List", Integer.toString(list.size()));
      if(list.size() != 0 && list != null ) textReq.setText(list.size());

//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    response_text = ApiCall.GET(client, RequestBuilder.buildURL("users"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Log.d("req", response_text);
//            }
//        });

        //textReq.setText(list.size());


    }

}
