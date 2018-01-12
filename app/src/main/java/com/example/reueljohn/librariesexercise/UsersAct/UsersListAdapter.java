package com.example.reueljohn.librariesexercise.UsersAct;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reueljohn.librariesexercise.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class UsersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Users> users = new ArrayList<>();
    private LayoutInflater mInflater;


    public UsersListAdapter(List<Users> users){

        this.users = users;


    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.users_list, parent, false);

        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        UsersViewHolder myHolder = (UsersViewHolder) holder;

        myHolder.nameText.setText(users.get(position).name);
        myHolder.usernameText.setText(users.get(position).username);
        myHolder.addressText.setText(users.get(position).street + " " + users.get(position).city);
        myHolder.companyText.setText(users.get(position).company);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView nameText;
        TextView usernameText;
        TextView addressText;
        TextView companyText;

        public UsersViewHolder(View view) {
            super(view);

            nameText = (TextView) view.findViewById(R.id.name);
            usernameText = (TextView) view.findViewById(R.id.username);
            addressText = (TextView) view.findViewById(R.id.address);
            companyText = (TextView) view.findViewById(R.id.company);

        }
    }




























}
