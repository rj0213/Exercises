package com.example.reueljohn.librariesexercise.UsersAct2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reueljohn.librariesexercise.R;
import com.example.reueljohn.librariesexercise.UsersAct2.POJO.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Users> users = new ArrayList<>();
    private LayoutInflater mInflater;

    public UsersAdapter(Context context, List<Users> users){
        mInflater = LayoutInflater.from(context);
        this.users = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.users_list, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Users current = users.get(position);
        UsersViewHolder myHolder = (UsersViewHolder) holder;
        myHolder.nameText.setText(current.getName());
        myHolder.usernameText.setText(current.getUsername());
        myHolder.addressText.setText(current.getAddress().getStreet() + " " + current.getAddress().getCity());
        myHolder.companyText.setText(current.getCompany().getName());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        TextView usernameText;
        TextView addressText;
        TextView companyText;


        public UsersViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.name);
            usernameText = (TextView) itemView.findViewById(R.id.username);
            addressText = (TextView) itemView.findViewById(R.id.address);
            companyText = (TextView) itemView.findViewById(R.id.company);
        }
    }
}
