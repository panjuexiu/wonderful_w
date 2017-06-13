package com.lilu.wonderful_watch.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.adapter.MyPagerAdapter;
import com.lilu.wonderful_watch.activity.adapter.MySimpleAdapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CinemaActivity extends Activity {
	//cinema3
	private ListView timeList1;
	//cinema4
	private ListView timeList2;
	//cinema3
	private MySimpleAdapter mSimpleAdapter1;
	//cinema4
	private MySimpleAdapter mSimpleAdapter2;
	
	public static String movieId;
	public static String movieName;
	private TextView movieTitle;
	private ImageView backImage;
	
	//to是绑定数据视图中的id
	private int[] dataTo=new int[]{R.id.cinema_tv_cinema,R.id.cinema_tv_address,
			R.id.cinema_tv_last1,R.id.cinema_tv_language1,R.id.cinema_tv_price1,
			R.id.cinema_tv_last2,R.id.cinema_tv_language2,R.id.cinema_tv_price2,
			R.id.cinema_tv_last3,R.id.cinema_tv_language3,R.id.cinema_tv_price3,
			R.id.cinema_tv_last4,R.id.cinema_tv_language4,R.id.cinema_tv_price4,
			R.id.cinema_tv_last5,R.id.cinema_tv_language5,R.id.cinema_tv_price5,
			R.id.cinema_tv_last6,R.id.cinema_tv_language6,R.id.cinema_tv_price6
			};
	//from是map中的key
	private String[] dataFrom=new String[]{"cinema","address",
			"last1","language1","price1","last2","language2","price2",
			"last3","language3","price3","last4","language4","price4",
			"last5","language5","price5","last6","language6","price6"
			};
	//view2
	private int[] dataTo2=new int[]{R.id.cinema_tv_cinema,R.id.cinema_tv_address,
			R.id.cinema_tv_last1,R.id.cinema_tv_language1,R.id.cinema_tv_price1,
			R.id.cinema_tv_last2,R.id.cinema_tv_language2,R.id.cinema_tv_price2,
			R.id.cinema_tv_last3,R.id.cinema_tv_language3,R.id.cinema_tv_price3,
			R.id.cinema_tv_last4,R.id.cinema_tv_language4,R.id.cinema_tv_price4,
			R.id.cinema_tv_last5,R.id.cinema_tv_language5,R.id.cinema_tv_price5,
			R.id.cinema_tv_last6,R.id.cinema_tv_language6,R.id.cinema_tv_price6
			};
	//from是map中的key
	private String[] dataFrom2=new String[]{"cinema","address",
			"last1","language1","price1","last2","language2","price2",
			"last3","language3","price3","last4","language4","price4",
			"last5","language5","price5","last6","language6","price6"
			};
	//这是放了map类型的list 就是这样
	private List<Map<String,Object>> dataList1;
	private List<Map<String,Object>> dataList2;
	//viewPager的数据源
	private List<View> dateList;
	private ViewPager viewPager;
	private View view1;
	private View view2;
	//viewPager的标题
	//private PagerTabStrip tab;
	private PagerTabStrip tab;
	private List<String> titleList;
	//为了在非Activity类里面使用Activity的startActivity方法
	public static CinemaActivity cinemaActivity;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.cinema);
		cinemaActivity=this;
		//初始化ViewPager
		initView();
		timeList1=(ListView) view1.findViewById(R.id.cinema_lv_timeList1);
		timeList2=(ListView) view2.findViewById(R.id.cinema_lv_timeList2);
		movieTitle = (TextView) findViewById(R.id.mine_tv_film);
		backImage = (ImageView) findViewById(R.id.mine_ib_back);
		dataList1=new ArrayList<Map<String,Object>>();
		dataList2=new ArrayList<Map<String,Object>>();
		mSimpleAdapter1=new MySimpleAdapter(this,dataList1,R.layout.cinema2,dataFrom,dataTo);
		mSimpleAdapter2=new MySimpleAdapter(this,dataList2,R.layout.cinema2,dataFrom2,dataTo2);
		//初始化ListView
		initList();
		timeList1.setAdapter(mSimpleAdapter1);
		timeList2.setAdapter(mSimpleAdapter2);
		
		movieId = getIntent().getStringExtra("movieId");
		movieName = getIntent().getStringExtra("movieName");
		movieTitle.setText(movieName);
		
		setListener();
	}
	private void setListener() {
		backImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				CinemaActivity.this.finish();
			}
		});
		
	}
	//viewPager
	private void initView() {
		dateList=new ArrayList<View>();
		//view对象是ViewPager的数据源--这样就不用写fragment了？？？
		view1 = View.inflate(this, R.layout.cinema3, null);
		view2 = View.inflate(this, R.layout.cinema4, null);
		dateList.add(view1);
		dateList.add(view2);
		//title
		titleList=new ArrayList<String>();
		titleList.add("今天05-05");
		titleList.add("明天05-06");
		//设置PagerTabStrip的属性
		tab=(PagerTabStrip) findViewById(R.id.tab);
		tab.setBackgroundColor(Color.WHITE);
		tab.setTextColor(Color.parseColor("#EC223A"));
		//通过设置透明度来修改未选中tab项的字体颜色
		tab.setNonPrimaryAlpha(0.2f);
		//将长线去掉
		tab.setDrawFullUnderline(false);
		//短线颜色
		tab.setTabIndicatorColor(Color.parseColor("#EC223A"));
		MyPagerAdapter mPagerAdapter=new MyPagerAdapter(dateList,titleList);
		viewPager=(ViewPager) findViewById(R.id.cinema_date);
		viewPager.setAdapter(mPagerAdapter);
	}
	public void initList() {
		//第一个item初始化
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cinema", "二七万达影城");
		map.put("address", "大学路");
		map.put("last1", "10:00");
		map.put("language1", "国语");
		map.put("price1", "20元");
		map.put("last2", "12:00");
		map.put("language2", "国语");
		map.put("price2", "20元");
		map.put("last3", "14:00");
		map.put("language3", "英语");
		map.put("price3", "20元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "20元");
		map.put("last5", "18:00");
		map.put("language5", "国语");
		map.put("price5", "20元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "20元");
		dataList1.add(map);
		//第二个item初始化
		map=new HashMap<String,Object>();
		map.put("cinema", "中原万达影城");
		map.put("address", "中原路");
		map.put("last1", "10:00");
		map.put("language1", "国语");
		map.put("price1", "30元");
		map.put("last2", "12:00");
		map.put("language2", "国语");
		map.put("price2", "30元");
		map.put("last3", "14:00");
		map.put("language3", "英语");
		map.put("price3", "30元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "30元");
		map.put("last5", "18:00");
		map.put("language5", "英语");
		map.put("price5", "30元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "30元");
		dataList1.add(map);
		//第三个item初始化
		map=new HashMap<String,Object>();
		map.put("cinema", "CGV大卫城店");
		map.put("address", "二七路");
		map.put("last1", "10:00");
		map.put("language1", "国语");
		map.put("price1", "30元");
		map.put("last2", "12:00");
		map.put("language2", "国语");
		map.put("price2", "30元");
		map.put("last3", "14:00");
		map.put("language3", "国语");
		map.put("price3", "30元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "30元");
		map.put("last5", "18:00");
		map.put("language5", "国语");
		map.put("price5", "30元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "30元");
		dataList1.add(map);
		//第四个item初始化
		map=new HashMap<String,Object>();
		map.put("cinema", "横店电影城");
		map.put("address", "德化步行街");
		map.put("last1", "10:00");
		map.put("language1", "国语");
		map.put("price1", "30元");
		map.put("last2", "12:00");
		map.put("language2", "英语");
		map.put("price2", "30元");
		map.put("last3", "14:00");
		map.put("language3", "英语");
		map.put("price3", "30元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "30元");
		map.put("last5", "18:00");
		map.put("language5", "国语");
		map.put("price5", "30元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "30元");
		dataList1.add(map);
		//第五个item初始化
		map=new HashMap<String,Object>();
		map.put("cinema", "奥斯卡高新影城");
		map.put("address", "科学大道");
		map.put("last1", "10:00");
		map.put("language1", "英语");
		map.put("price1", "30元");
		map.put("last2", "12:00");
		map.put("language2", "国语");
		map.put("price2", "30元");
		map.put("last3", "14:00");
		map.put("language3", "英语");
		map.put("price3", "30元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "30元");
		map.put("last5", "18:00");
		map.put("language5", "国语");
		map.put("price5", "30元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "30元");
		dataList1.add(map);
		//第六个item初始化
		map=new HashMap<String,Object>();
		map.put("cinema", "耀莱成龙国际影城");
		map.put("address", "棉纺路");
		map.put("last1", "10:00");
		map.put("language1", "国语");
		map.put("price1", "30元");
		map.put("last2", "12:00");
		map.put("language2", "国语");
		map.put("price2", "30元");
		map.put("last3", "14:00");
		map.put("language3", "英语");
		map.put("price3", "30元");
		map.put("last4", "16:00");
		map.put("language4", "国语");
		map.put("price4", "30元");
		map.put("last5", "18:00");
		map.put("language5", "国语");
		map.put("price5", "30元");
		map.put("last6", "20:00");
		map.put("language6", "国语");
		map.put("price6", "30元");
		dataList1.add(map);
		//pager2第一个item初始化--用不用新建一个map
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("cinema", "奥斯卡高新影城");
		map2.put("address", "科学大道");
		map2.put("last1", "10:00");
		map2.put("language1", "英语");
		map2.put("price1", "30元");
		map2.put("last2", "12:00");
		map2.put("language2", "国语");
		map2.put("price2", "30元");
		map2.put("last3", "14:00");
		map2.put("language3", "英语");
		map2.put("price3", "30元");
		map2.put("last4", "16:00");
		map2.put("language4", "国语");
		map2.put("price4", "30元");
		map2.put("last5", "18:00");
		map2.put("language5", "国语");
		map2.put("price5", "30元");
		map2.put("last6", "20:00");
		map2.put("language6", "国语");
		map2.put("price6", "30元");
		dataList2.add(map2);
		//pager2第二个item初始化
		map2=new HashMap<String,Object>();
		map2.put("cinema", "耀莱成龙国际影城");
		map2.put("address", "棉纺路");
		map2.put("last1", "10:00");
		map2.put("language1", "国语");
		map2.put("price1", "20元");
		map2.put("last2", "12:00");
		map2.put("language2", "国语");
		map2.put("price2", "20元");
		map2.put("last3", "14:00");
		map2.put("language3", "英语");
		map2.put("price3", "30元");
		map2.put("last4", "16:00");
		map2.put("language4", "国语");
		map2.put("price4", "30元");
		map2.put("last5", "18:00");
		map2.put("language5", "国语");
		map2.put("price5", "30元");
		map2.put("last6", "20:00");
		map2.put("language6", "国语");
		map2.put("price6", "30元");
		dataList2.add(map2);
	}
}
