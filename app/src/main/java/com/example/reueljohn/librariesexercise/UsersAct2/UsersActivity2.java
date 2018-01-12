package com.example.reueljohn.librariesexercise.UsersAct2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.reueljohn.librariesexercise.R;
import com.example.reueljohn.librariesexercise.UsersAct2.POJO.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsersActivity2 extends AppCompatActivity {

    private List<Users> users;
    private RecyclerView recyclerView;
    private UsersAdapter usersAdapter;
    private UsersAPI usersAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        recyclerView = (RecyclerView) findViewById(R.id.usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        usersAPI = UsersClient.getClient().create(UsersAPI.class);

        Call<List<Users>> call = usersAPI.getUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                usersAdapter = new UsersAdapter(UsersActivity2.this, response.body());
                recyclerView.setAdapter(usersAdapter);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });

    }
}
