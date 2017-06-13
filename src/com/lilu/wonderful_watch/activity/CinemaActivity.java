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
	
	//to�ǰ�������ͼ�е�id
	private int[] dataTo=new int[]{R.id.cinema_tv_cinema,R.id.cinema_tv_address,
			R.id.cinema_tv_last1,R.id.cinema_tv_language1,R.id.cinema_tv_price1,
			R.id.cinema_tv_last2,R.id.cinema_tv_language2,R.id.cinema_tv_price2,
			R.id.cinema_tv_last3,R.id.cinema_tv_language3,R.id.cinema_tv_price3,
			R.id.cinema_tv_last4,R.id.cinema_tv_language4,R.id.cinema_tv_price4,
			R.id.cinema_tv_last5,R.id.cinema_tv_language5,R.id.cinema_tv_price5,
			R.id.cinema_tv_last6,R.id.cinema_tv_language6,R.id.cinema_tv_price6
			};
	//from��map�е�key
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
	//from��map�е�key
	private String[] dataFrom2=new String[]{"cinema","address",
			"last1","language1","price1","last2","language2","price2",
			"last3","language3","price3","last4","language4","price4",
			"last5","language5","price5","last6","language6","price6"
			};
	//���Ƿ���map���͵�list ��������
	private List<Map<String,Object>> dataList1;
	private List<Map<String,Object>> dataList2;
	//viewPager������Դ
	private List<View> dateList;
	private ViewPager viewPager;
	private View view1;
	private View view2;
	//viewPager�ı���
	//private PagerTabStrip tab;
	private PagerTabStrip tab;
	private List<String> titleList;
	//Ϊ���ڷ�Activity������ʹ��Activity��startActivity����
	public static CinemaActivity cinemaActivity;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.cinema);
		cinemaActivity=this;
		//��ʼ��ViewPager
		initView();
		timeList1=(ListView) view1.findViewById(R.id.cinema_lv_timeList1);
		timeList2=(ListView) view2.findViewById(R.id.cinema_lv_timeList2);
		movieTitle = (TextView) findViewById(R.id.mine_tv_film);
		backImage = (ImageView) findViewById(R.id.mine_ib_back);
		dataList1=new ArrayList<Map<String,Object>>();
		dataList2=new ArrayList<Map<String,Object>>();
		mSimpleAdapter1=new MySimpleAdapter(this,dataList1,R.layout.cinema2,dataFrom,dataTo);
		mSimpleAdapter2=new MySimpleAdapter(this,dataList2,R.layout.cinema2,dataFrom2,dataTo2);
		//��ʼ��ListView
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
		//view������ViewPager������Դ--�����Ͳ���дfragment�ˣ�����
		view1 = View.inflate(this, R.layout.cinema3, null);
		view2 = View.inflate(this, R.layout.cinema4, null);
		dateList.add(view1);
		dateList.add(view2);
		//title
		titleList=new ArrayList<String>();
		titleList.add("����05-05");
		titleList.add("����05-06");
		//����PagerTabStrip������
		tab=(PagerTabStrip) findViewById(R.id.tab);
		tab.setBackgroundColor(Color.WHITE);
		tab.setTextColor(Color.parseColor("#EC223A"));
		//ͨ������͸�������޸�δѡ��tab���������ɫ
		tab.setNonPrimaryAlpha(0.2f);
		//������ȥ��
		tab.setDrawFullUnderline(false);
		//������ɫ
		tab.setTabIndicatorColor(Color.parseColor("#EC223A"));
		MyPagerAdapter mPagerAdapter=new MyPagerAdapter(dateList,titleList);
		viewPager=(ViewPager) findViewById(R.id.cinema_date);
		viewPager.setAdapter(mPagerAdapter);
	}
	public void initList() {
		//��һ��item��ʼ��
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cinema", "�������Ӱ��");
		map.put("address", "��ѧ·");
		map.put("last1", "10:00");
		map.put("language1", "����");
		map.put("price1", "20Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "����");
		map.put("price2", "20Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "Ӣ��");
		map.put("price3", "20Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "20Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "����");
		map.put("price5", "20Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "20Ԫ");
		dataList1.add(map);
		//�ڶ���item��ʼ��
		map=new HashMap<String,Object>();
		map.put("cinema", "��ԭ���Ӱ��");
		map.put("address", "��ԭ·");
		map.put("last1", "10:00");
		map.put("language1", "����");
		map.put("price1", "30Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "����");
		map.put("price2", "30Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "Ӣ��");
		map.put("price3", "30Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "30Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "Ӣ��");
		map.put("price5", "30Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "30Ԫ");
		dataList1.add(map);
		//������item��ʼ��
		map=new HashMap<String,Object>();
		map.put("cinema", "CGV�����ǵ�");
		map.put("address", "����·");
		map.put("last1", "10:00");
		map.put("language1", "����");
		map.put("price1", "30Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "����");
		map.put("price2", "30Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "����");
		map.put("price3", "30Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "30Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "����");
		map.put("price5", "30Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "30Ԫ");
		dataList1.add(map);
		//���ĸ�item��ʼ��
		map=new HashMap<String,Object>();
		map.put("cinema", "����Ӱ��");
		map.put("address", "�»����н�");
		map.put("last1", "10:00");
		map.put("language1", "����");
		map.put("price1", "30Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "Ӣ��");
		map.put("price2", "30Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "Ӣ��");
		map.put("price3", "30Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "30Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "����");
		map.put("price5", "30Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "30Ԫ");
		dataList1.add(map);
		//�����item��ʼ��
		map=new HashMap<String,Object>();
		map.put("cinema", "��˹������Ӱ��");
		map.put("address", "��ѧ���");
		map.put("last1", "10:00");
		map.put("language1", "Ӣ��");
		map.put("price1", "30Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "����");
		map.put("price2", "30Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "Ӣ��");
		map.put("price3", "30Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "30Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "����");
		map.put("price5", "30Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "30Ԫ");
		dataList1.add(map);
		//������item��ʼ��
		map=new HashMap<String,Object>();
		map.put("cinema", "ҫ����������Ӱ��");
		map.put("address", "�޷�·");
		map.put("last1", "10:00");
		map.put("language1", "����");
		map.put("price1", "30Ԫ");
		map.put("last2", "12:00");
		map.put("language2", "����");
		map.put("price2", "30Ԫ");
		map.put("last3", "14:00");
		map.put("language3", "Ӣ��");
		map.put("price3", "30Ԫ");
		map.put("last4", "16:00");
		map.put("language4", "����");
		map.put("price4", "30Ԫ");
		map.put("last5", "18:00");
		map.put("language5", "����");
		map.put("price5", "30Ԫ");
		map.put("last6", "20:00");
		map.put("language6", "����");
		map.put("price6", "30Ԫ");
		dataList1.add(map);
		//pager2��һ��item��ʼ��--�ò����½�һ��map
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("cinema", "��˹������Ӱ��");
		map2.put("address", "��ѧ���");
		map2.put("last1", "10:00");
		map2.put("language1", "Ӣ��");
		map2.put("price1", "30Ԫ");
		map2.put("last2", "12:00");
		map2.put("language2", "����");
		map2.put("price2", "30Ԫ");
		map2.put("last3", "14:00");
		map2.put("language3", "Ӣ��");
		map2.put("price3", "30Ԫ");
		map2.put("last4", "16:00");
		map2.put("language4", "����");
		map2.put("price4", "30Ԫ");
		map2.put("last5", "18:00");
		map2.put("language5", "����");
		map2.put("price5", "30Ԫ");
		map2.put("last6", "20:00");
		map2.put("language6", "����");
		map2.put("price6", "30Ԫ");
		dataList2.add(map2);
		//pager2�ڶ���item��ʼ��
		map2=new HashMap<String,Object>();
		map2.put("cinema", "ҫ����������Ӱ��");
		map2.put("address", "�޷�·");
		map2.put("last1", "10:00");
		map2.put("language1", "����");
		map2.put("price1", "20Ԫ");
		map2.put("last2", "12:00");
		map2.put("language2", "����");
		map2.put("price2", "20Ԫ");
		map2.put("last3", "14:00");
		map2.put("language3", "Ӣ��");
		map2.put("price3", "30Ԫ");
		map2.put("last4", "16:00");
		map2.put("language4", "����");
		map2.put("price4", "30Ԫ");
		map2.put("last5", "18:00");
		map2.put("language5", "����");
		map2.put("price5", "30Ԫ");
		map2.put("last6", "20:00");
		map2.put("language6", "����");
		map2.put("price6", "30Ԫ");
		dataList2.add(map2);
	}
}
