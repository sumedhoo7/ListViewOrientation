package com.dudupoo.listview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dudupoo on 28/11/16.
 */
public class ListFragment extends Fragment
{
    ListView listView;
    static List<String> listMembers;

    static HashMap<String, FlowerPOJO> mapMembers = new HashMap<>();
    ArrayAdapter<String> arrayAdapter;
    String mTime = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        listView = (ListView) v.findViewById(R.id.listView);

        FlowerPOJO rose = new FlowerPOJO("Rose", "Rose Description", R.drawable.rose_image);
        FlowerPOJO jasmine = new FlowerPOJO("Jasmine", "Jasmine Description", R.drawable.jasmine);
        mapMembers.put("Rose", rose);
        mapMembers.put("Jasmine", jasmine);
        listMembers = new ArrayList<>(mapMembers.keySet());


        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listMembers);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();

                DescriptionFragment fragment = new DescriptionFragment();
                Bundle args = new Bundle();
                args.putString("title",listMembers.get(i));

                fragment.setArguments(args);

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, fragment, "description_fragment")
                        .addToBackStack(null)
                        .commit();


            }
        });

        if (savedInstanceState != null) {
            // Restore last state
            mTime = savedInstanceState.getString("time_key");
        } else {
            mTime = "" + Calendar.getInstance().getTimeInMillis();
        }


        return v;
    }//end of onCreateView()

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("mTime", mTime);
    }
}
