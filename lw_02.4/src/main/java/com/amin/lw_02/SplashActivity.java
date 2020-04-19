package com.amin.lw_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;

public class SplashActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		final ProgressBar prgBar = (ProgressBar) findViewById(R.id.progressBar);

		if(savedInstanceState==null)
		{
			MyTask mt = new MyTask(new MyTask.DownloadListener()
			{
				@Override
				public void onPreExecute()
				{
					App.Log("MainActivity.onPreExecute.start");
					prgBar.setVisibility(ProgressBar.VISIBLE);
					App.Log("MainActivity.onPreExecute.end");
				}

				@Override
				public void onPostExecute(Void result)
				{
					App.Log("MainActivity.onPostExecute.start");
					prgBar.setVisibility(ProgressBar.INVISIBLE);
					App.Log("MainActivity.onPostExecute.end");

					Intent intent = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
					App.Log("SplashActivity.onCreate.start.MainActivity");
				}

				@Override
				public void doInBackground(Void... params)
						throws IOException, JSONException
				{
					App.Log("MainActivity.doInBackground.start");

					FileLoader.Load(App.JsonFileName, App.JsonFileUrl);
					String js = FileReader.Read(App.JsonFileName);
					File sdFile = new File(App.JsonFileName);
					sdFile.delete();

					App.JsonArray = new JSONArray(js);

					App.Log("MainActivity.doInBackground.end");
				}
			});
			mt.execute();
		}

		App.Log("SplashActivity.onCreate");
	}
}
