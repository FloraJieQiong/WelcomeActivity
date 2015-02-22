package com.example.welcomactivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity {

	private ViewPager guide_view_pager;
	private Button guide_btn;
	private List<ImageView> pages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);

		guide_view_pager = (ViewPager) findViewById(R.id.guide_view_pager);
		guide_btn = (Button) findViewById(R.id.guide_btn);

		guide_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(GuideActivity.this, MainActivity.class));
			}
		});

		pages = new ArrayList<ImageView>();
		ImageView ivGuide1 = new ImageView(GuideActivity.this);
		ivGuide1.setBackgroundResource(R.drawable.guide_1);
		pages.add(ivGuide1);

		ImageView ivGuide2 = new ImageView(GuideActivity.this);
		ivGuide2.setBackgroundResource(R.drawable.guide_2);
		pages.add(ivGuide2);

		ImageView ivGuide3 = new ImageView(GuideActivity.this);
		ivGuide3.setBackgroundResource(R.drawable.guide_3);
		pages.add(ivGuide3);

		ViewPagerAdapter adapter = new ViewPagerAdapter(pages);
		guide_view_pager.setAdapter(adapter);

		guide_view_pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				if (arg0 == 2) {
					guide_btn.setVisibility(View.VISIBLE);
				} else {
					guide_btn.setVisibility(View.GONE);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	class ViewPagerAdapter extends PagerAdapter {
		List<ImageView> pages = null;

		ViewPagerAdapter(List<ImageView> pages) {
			this.pages = pages;
		}

		//获取ImageView的数量
		@Override
		public int getCount() {
			return pages.size();
		}
		
		//判断是否是同一张图片
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
		// PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//super.destroyItem(container, position, object);
			((ViewPager)container).removeView(pages.get(position));
		}
		// 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			((ViewPager)container).addView(pages.get(position));
			return pages.get(position);
		}
	}
}
