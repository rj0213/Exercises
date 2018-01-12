package com.example.reueljohn.librariesexercise.UsersAct2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class UsersClient {

    public static Retrofit getClient(){

        String BASE_URL = "https://jsonplaceholder.typicode.com";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
