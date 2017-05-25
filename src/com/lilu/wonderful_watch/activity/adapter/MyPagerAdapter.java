package com.lilu.wonderful_watch.activity.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {
	private List<View> viewList;
	private List<String> titleList;
	public MyPagerAdapter(List<View> viewList,List<String> titleList){
		this.viewList = viewList;
		this.titleList = titleList;
	}

	@Override
	public int getCount() {
		// view的数量
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// view是否来自于对象
		return view==object;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// 实例化view
		container.addView(viewList.get(position));
		return viewList.get(position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// 销毁view
		container.removeView(viewList.get(position));
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// 设置标题--只有视图文件中包含PagerTabStrip子标签时才管用
		return titleList.get(position);
	}
}
