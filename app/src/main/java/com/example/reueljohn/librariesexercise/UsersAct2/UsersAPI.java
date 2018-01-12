package com.example.reueljohn.librariesexercise.UsersAct2;

import com.example.reueljohn.librariesexercise.UsersAct2.POJO.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by reueljohn on 12/01/2018.
 */

public interface UsersAPI {

    @GET("users")
    Call<List<Users>> getUsers();
}
