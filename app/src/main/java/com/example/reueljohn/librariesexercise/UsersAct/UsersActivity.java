package com.example.reueljohn.librariesexercise.UsersAct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.reueljohn.librariesexercise.R;

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        new GetUserInfo(this).execute();
    }
}
