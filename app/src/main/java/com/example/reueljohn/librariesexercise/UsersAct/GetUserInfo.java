package com.example.reueljohn.librariesexercise.UsersAct;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.reueljohn.librariesexercise.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class GetUserInfo extends AsyncTask<String, String ,String> {

    private List<Users> users = new ArrayList<>();
    private Activity activity;
    private RecyclerView recyclerView;
    private UsersListAdapter usersListAdapter;

    public GetUserInfo(Activity activity){

        this.activity = activity;
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getUsers();
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONArray usersArray = new JSONArray(s);
            for (int i = 0; i < usersArray.length(); i++){
                JSONObject user = usersArray.getJSONObject(i);
                JSONObject address = user.getJSONObject("address");
                JSONObject company = user.getJSONObject("company");
                Users newUser = new Users();

                newUser.name = user.getString("name");
                newUser.username = user.getString("username");
                newUser.street = address.getString("street");
                newUser.city = address.getString("city");
                newUser.company = company.getString("name");

                users.add(newUser);
            }

            recyclerView = (RecyclerView) activity.findViewById(R.id.usersList);
            usersListAdapter = new UsersListAdapter(activity,users);
            recyclerView.setAdapter(usersListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
