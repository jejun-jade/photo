package com.jejun.album;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("books")
    Call<Response> list(@Query("user_idx") String user_idx);


}
