package com.example.workwithapi;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;

public class RequestBuilder {


    public static RequestBody LoginBody(String username, String password, String token) {
        return new FormBody.Builder()
                .add("action", "login")
                .add("format", "json")
                .add("username", username)
                .add("password", password)
                .add("logintoken", token)
                .build();
    }

    public static HttpUrl buildURL(String pathSegment1) {
        return new HttpUrl.Builder()
                .scheme("https") //http
                .host("rest-api-for-student-map.herokuapp.com")
                .addPathSegment(pathSegment1)
                .build();
    }
        public static HttpUrl buildURL(String pathSegment1, String pathSegment2) {
            return new HttpUrl.Builder()
                    .scheme("https") //http
                    .host("rest-api-for-student-map.herokuapp.com")
                    .addPathSegment(pathSegment1)
                    .addPathSegment(pathSegment2)
                    .build();

    }

    public static HttpUrl buildURL(String pathSegment1, String pathSegment2, String pathSegment3) {
        return new HttpUrl.Builder()
                .scheme("https") //http
                .host("rest-api-for-student-map.herokuapp.com")
                .addPathSegment(pathSegment1)
                .addPathSegment(pathSegment2)
                .addPathSegment(pathSegment3)
                .build();

    }
}
