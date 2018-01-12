package com.example.reueljohn.librariesexercise.PhotosAct;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by reueljohn on 12/01/2018.
 */

public class GetPhotos extends AsyncTask<String, Void, Bitmap> {

    ImageView photoImage;

    public GetPhotos(ImageView imageView){

        this.photoImage = imageView;

    }


    @Override
    protected Bitmap doInBackground(String... strings) {

        String urls = strings[0];
        Bitmap bitmap = null;

        try {
            URL url = new URL(urls);
            InputStream inputStream = url.openConnection().getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);

            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        photoImage.setImageBitmap(bitmap);
    }
}
