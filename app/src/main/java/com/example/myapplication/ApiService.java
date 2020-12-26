package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
//ㅠㅠ
    @FormUrlEncoded
    @POST("person/")
    Call<Data> Update(
        @Field("id") int id,
        @Field("name") String name
    );

    @GET("person/")
    Call<Student> Bring(
            @Body int id
    );
}
