
package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    public static String IMAGE_ID = "imgId";
    public static String IMAGE_INDEX = "imgIndex";

    // TODO (1) Create a setter method and class variable to set and store of a list of image resources
    public void setImageId(List<Integer> imageId) {
        imageIds = imageId;
    }

    // TODO (2) Create another setter method and variable to track and set the index of the list item to display
    public void setImageIndex(int imageIndex) {
        imageIndexs = imageIndex;
    }

    // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on
    private List<Integer> imageIds;
    private int imageIndexs;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {
    }

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        if (savedInstanceState!=null){
            imageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID);
            imageIndexs = savedInstanceState.getInt(IMAGE_INDEX);
        }

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        // TODO (3) If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        if (imageIds != null) {
            imageView.setImageResource(imageIds.get(imageIndexs));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (imageIndexs < imageIds.size() - 1) {
                        imageIndexs++;
                    } else {
                        imageIndexs = 0;
                    }
                    imageView.setImageResource(imageIds.get(imageIndexs));
                }
            });
        } else {
            Log.d("BodyPartFragment", "Image list is null");
        }

        // Return the rootView
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID, (ArrayList<Integer>) imageIds);
        outState.putInt(IMAGE_INDEX,imageIndexs);
    }
}
