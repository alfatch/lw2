package com.amin.lw_02;

import android.app.Application;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.List;

public class App extends Application
{
	//	 в элементе списка маленькая картинка 64dp
	private static final int _itemImageHeight = 64;
	public static int PageImageSize;

	public static final String ARGUMENT_PAGE_NUMBER = "page_number";

	//	ссылка на json-файл
	public static final String TechnologiesUrl
			= "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/";

	//	спецификация json-файла
	private static List<Technologies> _technologies;

	private static final String LogTag = "amin_log";
	public static void Log(String msg) { Log.d(LogTag, msg); }
	public static void Error(String msg)
	{
		Log.e(LogTag, msg);
	}

	public static final int[] Colors = new int[2];

	public App()
	{
		Colors[0] = Color.parseColor("#FFFFFFFF");
		Colors[1] = Color.parseColor("#CCCCCCCC");
	}

	public static void CalcPageImageHeight(DisplayMetrics metrics)
	{
		float displayDp	= metrics.widthPixels / metrics.density;
		//	картинка большого размера (не больше ширины экрана-20dp)
		float imageDp = displayDp - 20;
		//	картинку увеличиваем в 5 раз
		float maxDp = _itemImageHeight * 3;
		if (maxDp < imageDp)
			imageDp = maxDp;

		App.PageImageSize = (int) (imageDp * metrics.widthPixels / displayDp);
	}

	public static String TechnologiesItemUrl(String url)
	{
		return "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/"
				+ url;
	}

	//	получить спецификацию json-файла
	public static void SetTechnologies(List<Technologies> technologies)
	{
		_technologies = technologies;
	}

	//	вернуть позицию спецификации json-файла
	public static Technologies TechnologiesGet(int index)
	{
		return _technologies.get(index + 1);
	}

	//	вернуть кол-во позиций спецификации json-файла
	public static int TechnologiesLength()
	{
		return _technologies != null ? _technologies.size() - 1 : 0;
	}
}
