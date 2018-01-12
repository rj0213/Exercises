package com.example.reueljohn.librariesexercise.PhotosAct;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reueljohn.librariesexercise.R;

import java.util.List;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class PhotosListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Photos> photos;

    public PhotosListAdapter(Context context, List<Photos> photos){

        this.photos = photos;
        mInflater = LayoutInflater.from(context);

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.users_list, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PhotosViewHolder myHolder = (PhotosViewHolder) holder;
        myHolder.titleText.setText(photos.get(position).title);
        myHolder.urlText.setText(photos.get(position).url);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


    class PhotosViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;
        TextView urlText;
        ImageView photoImage;

        public PhotosViewHolder(View view) {
            super(view);

            titleText = (TextView) view.findViewById(R.id.titleTxt);
            urlText = (TextView) view.findViewById(R.id.urlTxt);
            photoImage = (ImageView) view.findViewById(R.id.photoImg);

        }
    }




















}
