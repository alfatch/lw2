package com.amin.lw_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl(App.TechnologiesUrl)
					.addConverterFactory(GsonConverterFactory.create())
					.build();

			TechnologiesService requestService = retrofit.create(TechnologiesService.class);
			Call<List<Technologies>> call = requestService.getTechnologiesJson();

			prgBar.setVisibility(ProgressBar.VISIBLE);

			call.enqueue(new Callback<List<Technologies>>()
			{
				@Override
				public void onResponse(Call<List<Technologies>> call, Response<List<Technologies>> response)
				{
					App.SetTechnologies(new ArrayList<>(response.body()));

					prgBar.setVisibility(ProgressBar.INVISIBLE);
					Intent intent = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}

				@Override
				public void onFailure(Call<List<Technologies>> call, Throwable t)
				{
					App.Error(t.getMessage());
				}
			});
		}

		App.Log("SplashActivity.onCreate");
	}
}
