package com.example.wonderful_watch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnItemClickListener,OnScrollListener {

	//3.14声明变量
	private ViewPager mViewPager;
	private FragmentPagerAdapter mPagerAdapter;
	private List<Fragment> mData=new ArrayList<Fragment>();
	private TextView cellTv;
	private TextView mailTv;
	private int mHalf;
	private ImageView mHalfScreen;
	private int mCurrentPageIndex;
	//就这样试试吧 感觉会可丑
	private ListView mListView;
	private SimpleAdapter mSimpleAdapter;
	//to是绑定数据视图中的id
	private int[] dataTo=new int[]{R.id.home_iv_film,R.id.home_tv_film,R.id.home_tv_director,R.id.home_tv_cast};
	//from是map中的key
	private String[] dataFrom=new String[]{"post","film","director","cast"};
	//这是干嘛的--放了map类型的list 就是这样
	private List<Map<String,Object>> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//不显示title bar--总是报错--是不是位置不对
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//测试--一个一个来吧
		setContentView(R.layout.activity_main);
		//注册--sign up
//		initTabLine();
//		initView();
		//主页--home
//		initList();
	}
	//主页--home
	private void initList() {
		mListView=(ListView) findViewById(R.id.home_lv_filmList);
		dataList=new ArrayList<Map<String,Object>>();
		mSimpleAdapter=new SimpleAdapter(this,dataList,R.layout.home2,dataFrom,dataTo);
		
		//如何获取到值--3.16
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("post", R.drawable.film);
			map.put("film", "初始化电影名"+i);
			map.put("director", "初始化导演");
			map.put("cast", "初始化演职员表");
			dataList.add(map);
		}
		//将适配器与组件绑定
		mListView.setAdapter(mSimpleAdapter);
		//将监听器与组件绑定--为什么绑定不上--因为按钮获取了焦点
		mListView.setOnItemClickListener(MainActivity.this);
		mListView.setOnScrollListener(MainActivity.this);
	}
	//注册--sign up
	private void initTabLine() {
		// 这个变量一直获取不到
		mHalfScreen=(ImageView) findViewById(R.id.signup_iv_half);
		Display display=getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics oMetrics=new DisplayMetrics();
		display.getMetrics(oMetrics);
		mHalf=oMetrics.widthPixels/2;
		LayoutParams mLayoutParams=mHalfScreen.getLayoutParams();
		mLayoutParams.width=mHalf;
		mHalfScreen.setLayoutParams(mLayoutParams);
	}
	//注册--sign up
	private void initView() {
		// TODO Auto-generated method stub
		mViewPager=(ViewPager) findViewById(R.id.sign_vp);
		//实例化集合的任务 已经提前实现
		CellMainTabFragment cellTab=new CellMainTabFragment();
		MailMainTabFragment mailTab=new MailMainTabFragment();
		mData.add(cellTab);
		mData.add(mailTab);
		cellTv=(TextView) findViewById(R.id.textView_cell);
		mailTv=(TextView) findViewById(R.id.textView_mail);
		mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mData.size();
			}
			
			@Override
			//这个参数名还是姐姐提示的
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				return mData.get(position);
			}
		};
		//适配器和组件配对
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// 滑动结束时修改字体颜色
				resetTextColor();
				switch (position) {
				case 0:
					cellTv.setTextColor(Color.parseColor("#20B2AA"));
					break;
				case 1:
					mailTv.setTextColor(Color.parseColor("#20B2AA"));
					break;
				}
				mCurrentPageIndex=position;
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPx) {
				// 页面切换时指示器移动所用的方法
				LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) mHalfScreen.getLayoutParams();
				//0到1页
				if(mCurrentPageIndex==0&&position==0){
					layoutParams.leftMargin=(int) (positionOffset*mHalf+mCurrentPageIndex*mHalf);
				//0到1页  Offset从0到0.9
				}else if(mCurrentPageIndex==1&&position==0){
					layoutParams.leftMargin=(int) (mCurrentPageIndex*mHalf+(positionOffset-1)*mHalf);
				}
				mHalfScreen.setLayoutParams(layoutParams);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	protected void resetTextColor() {
		// TODO Auto-generated method stub
		cellTv.setTextColor(Color.BLACK);
		mailTv.setTextColor(Color.BLACK);
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// 接口的方法
		
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// 接口的方法--这个其实用不到吖吖吖
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Log.i("tag--", "手指已经离开屏幕，视图还在滑动");
			//向下刷新
			Map<String,Object> fresh=new HashMap<String,Object>();
			//刷新加载--3.17
			fresh.put("post", R.drawable.film_1);
			fresh.put("film","新增电影");
			fresh.put("director", "新增导演");
			fresh.put("cast", "新增演职员表");
			dataList.add(fresh);
			//刷新ui界面
			mSimpleAdapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("tag--", "视图已经停止");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("tag--", "手指没有离开屏幕，而且视图在滑动");
			break;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// 接口的方法
		String str=mListView.getItemAtPosition(position)+"";
		Toast.makeText(this, "点击进入电影详情"+position, Toast.LENGTH_SHORT).show();
		//Log.i("tag--", str);
	}
}
