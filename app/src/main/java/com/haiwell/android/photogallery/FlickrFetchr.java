package com.haiwell.android.photogallery;

import android.net.Uri;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by RJ-HXW on 2017/11/2.
 */

public class FlickrFetchr {
    private static final String TAG = FlickrFetchr.class.getSimpleName();

    private static final String ENDPOINT = "https://api.flickr.com/services/rest";
    private static final String API_KEY = "214e3d38745b5eff0b31724974bef69e";
    private static final String METHOD_GET = "flickr.photos.getRecent";
    private static final String PARAM_EXTRAS = "extras";
    private static final String EXTRA_SMALL_URL = "url_s";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            InputStream inputStream = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return null;
            }

            int byteRead = 0;
            byte[] buffer = new byte[1024];
            while ((byteRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, byteRead);
            }
            outputStream.close();
            return outputStream.toByteArray();
        }finally {
            connection.disconnect();
        }
    }

    public String getUrl(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public void fetchItems() {
        try {
            String url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", METHOD_GET)
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter(PARAM_EXTRAS, EXTRA_SMALL_URL)
                    .build().toString();
            String xmlString = getUrl(url);
            Log.i(TAG, "Received xml:" + xmlString);
        } catch (IOException e) {
            Log.e(TAG, "Failed to fetch items", e);
        }
    }
}
