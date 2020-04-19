package com.amin.lw_02;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

public class FormActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);

		Intent intent = this.getIntent();
		int pageIndex =  intent.getIntExtra(App.ARGUMENT_PAGE_NUMBER, 1);

		ViewPager pager = (ViewPager) findViewById(R.id.pagerId);
		PagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
		pager.setAdapter	(pagerAdapter);
		pager.setCurrentItem(pageIndex);
		pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{
			@Override
			public void onPageSelected(int position)
			{
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
									   int positionOffsetPixels)
			{
			}

			@Override
			public void onPageScrollStateChanged(int state)
			{
			}
		});
	}

	private class MyFragmentPagerAdapter extends FragmentPagerAdapter
	{

		public MyFragmentPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int position)
		{
			return FormPageFragment.newInstance(position);
		}

		@Override
		public int getCount()
		{
			return App.JsonArrayLength();
		}

	}
}
