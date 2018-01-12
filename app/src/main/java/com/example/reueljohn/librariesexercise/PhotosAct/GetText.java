package com.example.reueljohn.librariesexercise.PhotosAct;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.reueljohn.librariesexercise.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class GetText extends AsyncTask<String, String,String> {

    private List<Photos> photos;
    private Activity activity;
    private RecyclerView recyclerView;
    private PhotosListAdapter photosListAdapter;


    public GetText(Activity activity){
        this.activity = activity;
    }


    @Override
    protected String doInBackground(String... strings) {
        return NetworkConnect.getPhotos();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONArray photosArray = new JSONArray(s);
            for (int i = 0; i < photosArray.length(); i++){
                JSONObject photoNum = photosArray.getJSONObject(i);
                //JSONObject photoURL = photoNum.getJSONObject("url");
                Photos newPhoto = new Photos();

                newPhoto.title = photoNum.getString("title");
                newPhoto.url = photoNum.getString("url");

                photos.add(newPhoto);

            }

            recyclerView = (RecyclerView) activity.findViewById(R.id.photosList);
            photosListAdapter = new PhotosListAdapter(activity, photos);
            recyclerView.setAdapter(photosListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
