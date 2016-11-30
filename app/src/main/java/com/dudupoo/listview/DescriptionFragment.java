package com.dudupoo.listview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dudupoo on 28/11/16.
 */
public class DescriptionFragment extends Fragment
{

    TextView titleText, descriptionTextView;
    ImageView imageView;
    HashMap<String, FlowerPOJO> rxHashMap = new HashMap<>();
    ArrayList<String> topicArray = new ArrayList<>();
    FlowerPOJO flower;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_description, container, false);

        titleText = (TextView) v.findViewById(R.id.titleTopic);
        descriptionTextView = (TextView) v.findViewById(R.id.description);
        imageView = (ImageView) v.findViewById(R.id.imageDesc);

        String key = getArguments().getString("title");
        rxHashMap = ListFragment.mapMembers;
        if(rxHashMap.containsKey(key))
        {
            flower = rxHashMap.get(key);
            titleText.setText(flower.getTitle());
            descriptionTextView.setText(flower.getDescription());
            imageView.setImageResource(flower.getImageID());
        }

        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }
}
