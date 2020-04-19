package com.amin.lw_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		App.CalcPageImageHeight(displaymetrics);

		RecyclerView view = findViewById(R.id.mainLayoutId);
		LinearLayoutManager manager = new LinearLayoutManager(this);
		view.setLayoutManager(manager);
		view.setHasFixedSize(true);

		RecyclerViewAdapter adapter =
				new RecyclerViewAdapter(App.TechnologiesLength(), new RecyclerViewAdapter.OnClickListener()
		{
			@Override
			public void onClick(int index)
			{
				Intent intent = new Intent(MainActivity.this, FormActivity.class);
				intent.putExtra(App.ARGUMENT_PAGE_NUMBER, index);
				startActivity(intent);
				App.Log("Click! " + index);
			}
		});
		view.setAdapter(adapter);
    }
}
