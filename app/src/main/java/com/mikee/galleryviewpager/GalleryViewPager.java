package com.mikee.galleryviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
 * 自定义Viewpage,宽度进行重绘
 *
 * @author Administrator
 */
public class GalleryViewPager extends ViewPager {

    private DisplayMetrics displayMetrics;

    public GalleryViewPager(Context context) {
        super(context);
        init();
    }

    public GalleryViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        displayMetrics = getContext().getResources().getDisplayMetrics();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                displayMetrics.widthPixels - getPageMargin() * 8,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
