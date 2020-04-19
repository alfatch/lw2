package com.amin.lw_02;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;

public class MyTask extends AsyncTask<Void, Void, Void>
{
	public interface DownloadListener
	{
		void onPreExecute();
		void onPostExecute(Void result);
		void doInBackground(Void... params) throws IOException, JSONException;
	}

	private DownloadListener _listner;

	public MyTask(DownloadListener listner)
	{
		_listner = listner;
	}
	@Override
	protected void onPreExecute()
	{
		App.Log("MyTask.onPreExecute.start");
		super.onPreExecute();
		_listner.onPreExecute();
		App.Log("MyTask.onPreExecute.end");
	}

	@Override
	protected Void doInBackground(Void... params)
	{
		App.Log("MyTask.doInBackground.start");
		try
		{
			_listner.doInBackground(params);
			//TimeUnit.SECONDS.sleep(10);
			//FileLoader.Load(App.JsonFileName, App.JsonFileUrl);
		}
		catch(Exception e)
		{
			App.Error(e.getMessage());
		}
		App.Log("MyTask.doInBackground.end");
		return null;
	}

	@Override
	protected void onPostExecute(Void result)
	{
		App.Log("MyTask.onPostExecute.start");
		super.onPostExecute(result);
		_listner.onPostExecute(result);
		App.Log("MyTask.onPostExecute.end");
	}
}
