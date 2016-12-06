package com.mikee.galleryviewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
/**
 * 这里实现缩小以及阴影效果
 * @author Administrator
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DepthPageTransformer implements PageTransformer {
	private static final float MIN_SCALE = 0.8f;
	private static final float MIN_ALPHA = 0.5f;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	public void transformPage(View view, float position) {
		if (position < -1) { // [-Infinity,-1)
			// This page is way off-screen to the left.
			view.setScaleY(MIN_SCALE);
			view.setAlpha(MIN_ALPHA);
		} else if (position == 0) { // [-1,0]
			// Use the default slide transition when moving to the left page
			view.setScaleY(1);
			view.setAlpha(1);
		} else if (position <= 1) { // (0,1]
			// Fade the page out.

			// Counteract the default slide transition

			// Scale the page down (between MIN_SCALE and 1)
			float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
					* (1 - Math.abs(position));
			float alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA)
					* (1 - Math.abs(position));
			view.setScaleY(scaleFactor);
			view.setAlpha(alphaFactor);
		} else { // (1,+Infinity]
			// This page is way off-screen to the right.
			view.setScaleY(MIN_SCALE);
			view.setAlpha(MIN_ALPHA);
		}
	}
}