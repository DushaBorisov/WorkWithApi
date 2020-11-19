package com.example.workwithapi;

import android.util.Log;

import com.example.workwithapi.Entity.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;

public class RequestMaker {

    ExecutorService service = Executors.newFixedThreadPool(5);
    OkHttpClient client;

    public  ArrayList<User> GetAllUsers(OkHttpClient client1){

        client = client1;
        final ArrayList<User> users = new ArrayList<User>();
        Log.d("RequestMaker", "IN function");

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("RequestMaker", "IN thread");
                    String response_text;
                    response_text = ApiCall.GET(client,RequestBuilder.buildURL("users"));
                    Log.d("RequestMaker", response_text);

                    if(response_text != "NOT_FOUND" && response_text != "SERVER_ERROR" && response_text != "ERROR"){

                        try {
                            JSONArray jsonArray = new JSONArray(response_text);

                            for(int  i =0; i < jsonArray.length(); i++){

                                User user = new User();
                                user.setLogin(jsonArray.getJSONObject(i).getString("login"));
                                user.setPassword(jsonArray.getJSONObject(i).getString("password"));
                                user.setName(jsonArray.getJSONObject(i).getString("name"));
                                user.setSurname(jsonArray.getJSONObject(i).getString("surname"));
                                user.setAge(jsonArray.getJSONObject(i).getInt("age"));
                                user.setGender(jsonArray.getJSONObject(i).getString("gender"));
                                users.add(user);
                                Log.d("user", user.getName() + "  "+  user.getPassword() + " " + user.getLogin()  );
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        return users;
    }

    public static User GetUserByLogin(OkHttpClient client1 ,String login){
       User user = new User();

       return user;
    }

    public static User GetUserByLoginAndPassword(String login, String password){
        User user = new User();

        return user;
    }

}
