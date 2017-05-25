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
		// view������
		return viewList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// view�Ƿ������ڶ���
		return view==object;
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// ʵ����view
		container.addView(viewList.get(position));
		return viewList.get(position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// ����view
		container.removeView(viewList.get(position));
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// ���ñ���--ֻ����ͼ�ļ��а���PagerTabStrip�ӱ�ǩʱ�Ź���
		return titleList.get(position);
	}
}
