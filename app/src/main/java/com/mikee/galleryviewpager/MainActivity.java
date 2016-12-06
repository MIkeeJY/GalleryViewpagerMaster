package com.mikee.galleryviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainActivity extends FragmentActivity {

	private GalleryViewPager mViewPager;
	private GalleryAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (GalleryViewPager) findViewById(R.id.view_pager);
		mViewPager.setAdapter(adapter = new GalleryAdapter(getSupportFragmentManager()));
		mViewPager.setPageMargin(30);// 设置页面间距
		mViewPager.setOffscreenPageLimit(2);
		mViewPager.setCurrentItem(0);// 设置起始位置
		mViewPager.setPageTransformer(true, new DepthPageTransformer());
	}

	class GalleryAdapter extends FragmentPagerAdapter {

		int count = 3;// 默认10

		public GalleryAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			return ItemFragment.create(String.format("这里是第%d页", position));
		}

		/**
		 * 数量设置为最大
		 * 
		 * @return
		 */
		@Override
		public int getCount() {
			return 10;
		}

		/**
		 * 真实数量
		 * 
		 * @return
		 */
		public int getRealCount() {
			return this.count;
		}
	}

}
