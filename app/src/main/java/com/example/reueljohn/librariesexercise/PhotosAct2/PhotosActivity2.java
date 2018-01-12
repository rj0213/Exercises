package com.example.reueljohn.librariesexercise.PhotosAct2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.reueljohn.librariesexercise.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PhotosAdapter photosAdapter;
    private PhotosAPI photosAPI;
    private List<Photos> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);


        recyclerView = (RecyclerView) findViewById(R.id.photosList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        photosAPI = PhotosClient.getClient().create(PhotosAPI.class);

        Call<List<Photos>> call = photosAPI.getPhoto();
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                photosAdapter = new PhotosAdapter(PhotosActivity2.this, response.body());
                recyclerView.setAdapter(photosAdapter);
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });



    }
}
