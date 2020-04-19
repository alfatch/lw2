package com.amin.lw_02;

import android.app.Application;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;

import org.json.JSONArray;

public class App extends Application
{
	public static class Display
	{
		public float XDp;
		public float YDp;
	}

	public static Display Display;
	public static final String ARGUMENT_PAGE_NUMBER = "page_number";
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
	public static final String[] PageFiels = new String[2];

	public App()
	{
		PageFiels[0] = "name";
		PageFiels[1] = "helptext";
	}
	public static void Log(String msg) { Log.d(LogTag, msg); }
	public static void Error(String msg)
	{
		Log.e(LogTag, msg);
	}
	public static void SeDisplayMetrics(DisplayMetrics metrics)
	{
		Display = new App.Display();
		Display.XDp = _calcDp(metrics.xdpi, metrics.scaledDensity);
		Display.YDp = _calcDp(metrics.xdpi, metrics.scaledDensity);
	}

	private static int _calcDp(float px, float scale)
	{
		return (int)(px * 160 / scale);
	}
}
