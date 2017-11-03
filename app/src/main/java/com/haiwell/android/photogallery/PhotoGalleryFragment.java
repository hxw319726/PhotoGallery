package com.haiwell.android.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by RJ-HXW on 2017/11/2.
 */

public class PhotoGalleryFragment extends Fragment {
    private static final String TAG = PhotoGalleryFragment.class.getSimpleName();
    GridView mGridView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);

        mGridView = ((GridView) view.findViewById(R.id.gridView));


        return view;
    }

    /*AsyncTask后台工具*/

    private class FetchItemsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Log.e(TAG, "doInBackground:");
//            try {
//                String result = new FlickrFetchr().getUrl("https://api.flickr.com/services/rest");
//                Log.i(TAG, "Fetched contents of URL:" + result);
//            } catch (IOException e) {
//                Log.e(TAG, "Failed to fetch URL:", e);
//            }
            new FlickrFetchr().fetchItems();
            return null;
        }
    }

}
