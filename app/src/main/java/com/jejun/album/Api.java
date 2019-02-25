package com.jejun.album;

import android.content.Context;

import com.jejun.album.object.Album;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Api {

    public static Retrofit get() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("API_URL")
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    private static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request.Builder builder = chain.request().newBuilder();

                    return chain.proceed(builder.build());
                })
                .followRedirects(true)
                .followSslRedirects(true)
                .build();
    }

    public static void login(Context context, String id, String pw) {
        // TODO : login api 호출
    }

    public static void request(Context context, String user_idx) {

       ApiService service = get().create(ApiService.class);
       service.list(user_idx).enqueue(new Callback<Response>() {
           @Override
           public void onResponse(Call<Response> call, Response<Response> response) {
               // TODO : response 객체화 -> view

           }

           @Override
           public void onFailure(Call<Response> call, Throwable t) {

           }
       });

    }
}
