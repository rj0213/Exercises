package com.example.reueljohn.librariesexercise.PhotosAct2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by reueljohn on 12/01/2018.
 */

public interface PhotosAPI {

    @GET("photos")
    Call<List<Photos>> getPhoto();

}
