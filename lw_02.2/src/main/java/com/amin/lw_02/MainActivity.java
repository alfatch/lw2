package com.amin.lw_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		RecyclerView view = findViewById(R.id.mainLayoutId);
		LinearLayoutManager manager = new LinearLayoutManager(this);
		view.setLayoutManager(manager);
		view.setHasFixedSize(true);

		App.Log("MainActivity.onCreate.App.JSONArray.length()="+App.JsonArrayLength());
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(App.JsonArray.length());
		view.setAdapter(adapter);
    }
}
