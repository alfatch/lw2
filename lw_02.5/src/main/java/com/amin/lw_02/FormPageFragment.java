package com.amin.lw_02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SizeReadyCallback;

public class FormPageFragment extends Fragment
{
	private int _pageNumber;

	static FormPageFragment newInstance(int pageNumber)
	{
		FormPageFragment fragment 	= new FormPageFragment();
		Bundle arguments 			= new Bundle();
		arguments.putInt(App.ARGUMENT_PAGE_NUMBER, pageNumber);
		fragment.setArguments(arguments);

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		_pageNumber = getArguments().getInt(App.ARGUMENT_PAGE_NUMBER);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.form_fragment, null);

		Technologies t = App.TechnologiesGet(_pageNumber);
		String url     = t.getGraphic();

		ImageView graphic = view.findViewById(R.id.formGraphicId);
		graphic.getLayoutParams().height 	= App.PageImageSize;
		graphic.getLayoutParams().width 	= App.PageImageSize;

		Glide.with(view)
				.load(App.TechnologiesItemUrl(url))
				.fitCenter()
				.placeholder(R.drawable.graphic)
				.into(graphic);

		WebView webView = (WebView) view.findViewById(R.id.formTextId);
		webView.loadDataWithBaseURL(null, t.getHtml(), "text/html", "utf-8", null);

		return view;
	}
}
