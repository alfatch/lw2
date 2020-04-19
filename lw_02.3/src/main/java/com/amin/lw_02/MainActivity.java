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

		RecyclerViewAdapter adapter = new RecyclerViewAdapter(App.JsonArray.length(), new RecyclerViewAdapter.OnClickListener()
		{
			@Override
			public void onClick(int index)
			{
				App.Error("onClick2");
			}
		});
		view.setAdapter(adapter);
    }
}
