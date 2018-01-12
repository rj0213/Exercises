package com.example.reueljohn.librariesexercise.PhotosAct2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class PhotosClient {

    public static Retrofit getClient(){

        String BASE_URL = "https://jsonplaceholder.typicode.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
