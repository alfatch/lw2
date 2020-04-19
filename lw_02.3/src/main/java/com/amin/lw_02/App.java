package com.amin.lw_02;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;

public class App extends Application
{
	private static final String LogTag = "amin_log";

	public static String JsonFileUrl = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";
	public static String GgraphicUrl(String url)
	{
		return "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/"
				+ url;
	}
	public static String JsonFileName = Environment.getExternalStorageDirectory() + "/my.txt";
	public static JSONArray JsonArray;
	public static int JsonArrayLength() { return JsonArray != null ? JsonArray.length() - 1 : 0; }

	public static void Log(String msg) { Log.d(LogTag, msg); }

	public static void Error(String msg)
	{
		Log.e(LogTag, msg);
	}
}
