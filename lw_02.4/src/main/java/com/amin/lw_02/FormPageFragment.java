package com.amin.lw_02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class FormPageFragment extends Fragment
{
	private int _pageNumber;
	private int _backColor;

	static FormPageFragment newInstance(int page)
	{
		FormPageFragment fragment = new FormPageFragment();
		Bundle arguments = new Bundle();
		arguments.putInt(App.ARGUMENT_PAGE_NUMBER, page);
		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		_pageNumber = getArguments().getInt(App.ARGUMENT_PAGE_NUMBER);

		Random rnd = new Random();
		_backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.form_fragment, null);

		JSONObject post = null;
		try
		{
			post = App.JsonArray.getJSONObject(_pageNumber + 1);
			String url      = post.getString("graphic");

			TextView text = (TextView) view.findViewById(R.id.formTextId);
			String fn;
			text.setLines(App.PageFiels.length);
			for(int i=0; i<App.PageFiels.length; i++)
			{
				fn = App.PageFiels[i];
				if (post.isNull(fn) == false)
					text.append(fn + ":" + post.getString(fn));
			}
			text.setBackgroundColor(_backColor);

			ImageView graphic = view.findViewById(R.id.formGraphicId);
			//LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10, 100);
			//graphic.setLayoutParams(layoutParams);

			Glide.with(view)
					.load(App.GgraphicUrl(url))
					.centerCrop()
					.placeholder(R.drawable.graphic)
					.into(graphic);

		} catch (JSONException e)
		{
			App.Error(e.getMessage());
			e.printStackTrace();
		}

		return view;
	}
}
