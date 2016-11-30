package com.dudupoo.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    Fragment listFragmnet;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(savedInstanceState != null)
            listFragmnet =  getSupportFragmentManager().findFragmentByTag("list_fragment");
        else
        {
            listFragmnet = new ListFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, listFragmnet, "list_fragment")
                    .addToBackStack(null)
                    .commit();
        }
    }
}
