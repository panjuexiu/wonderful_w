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

	//3.14��������
	private ViewPager mViewPager;
	private FragmentPagerAdapter mPagerAdapter;
	private List<Fragment> mData=new ArrayList<Fragment>();
	private TextView cellTv;
	private TextView mailTv;
	private int mHalf;
	private ImageView mHalfScreen;
	private int mCurrentPageIndex;
	//���������԰� �о���ɳ�
	private ListView mListView;
	private SimpleAdapter mSimpleAdapter;
	//to�ǰ�������ͼ�е�id
	private int[] dataTo=new int[]{R.id.home_iv_film,R.id.home_tv_film,R.id.home_tv_director,R.id.home_tv_cast};
	//from��map�е�key
	private String[] dataFrom=new String[]{"post","film","director","cast"};
	//���Ǹ����--����map���͵�list ��������
	private List<Map<String,Object>> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����ʾtitle bar--���Ǳ���--�ǲ���λ�ò���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//����--һ��һ������
		setContentView(R.layout.activity_main);
		//ע��--sign up
//		initTabLine();
//		initView();
		//��ҳ--home
//		initList();
	}
	//��ҳ--home
	private void initList() {
		mListView=(ListView) findViewById(R.id.home_lv_filmList);
		dataList=new ArrayList<Map<String,Object>>();
		mSimpleAdapter=new SimpleAdapter(this,dataList,R.layout.home2,dataFrom,dataTo);
		
		//��λ�ȡ��ֵ--3.16
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("post", R.drawable.film);
			map.put("film", "��ʼ����Ӱ��"+i);
			map.put("director", "��ʼ������");
			map.put("cast", "��ʼ����ְԱ��");
			dataList.add(map);
		}
		//���������������
		mListView.setAdapter(mSimpleAdapter);
		//���������������--Ϊʲô�󶨲���--��Ϊ��ť��ȡ�˽���
		mListView.setOnItemClickListener(MainActivity.this);
		mListView.setOnScrollListener(MainActivity.this);
	}
	//ע��--sign up
	private void initTabLine() {
		// �������һֱ��ȡ����
		mHalfScreen=(ImageView) findViewById(R.id.signup_iv_half);
		Display display=getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics oMetrics=new DisplayMetrics();
		display.getMetrics(oMetrics);
		mHalf=oMetrics.widthPixels/2;
		LayoutParams mLayoutParams=mHalfScreen.getLayoutParams();
		mLayoutParams.width=mHalf;
		mHalfScreen.setLayoutParams(mLayoutParams);
	}
	//ע��--sign up
	private void initView() {
		// TODO Auto-generated method stub
		mViewPager=(ViewPager) findViewById(R.id.sign_vp);
		//ʵ�������ϵ����� �Ѿ���ǰʵ��
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
			//������������ǽ����ʾ��
			public Fragment getItem(int position) {
				// TODO Auto-generated method stub
				return mData.get(position);
			}
		};
		//��������������
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// ��������ʱ�޸�������ɫ
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
				// ҳ���л�ʱָʾ���ƶ����õķ���
				LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) mHalfScreen.getLayoutParams();
				//0��1ҳ
				if(mCurrentPageIndex==0&&position==0){
					layoutParams.leftMargin=(int) (positionOffset*mHalf+mCurrentPageIndex*mHalf);
				//0��1ҳ  Offset��0��0.9
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
		// �ӿڵķ���
		
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// �ӿڵķ���--�����ʵ�ò���߹߹߹
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Log.i("tag--", "��ָ�Ѿ��뿪��Ļ����ͼ���ڻ���");
			//����ˢ��
			Map<String,Object> fresh=new HashMap<String,Object>();
			//ˢ�¼���--3.17
			fresh.put("post", R.drawable.film_1);
			fresh.put("film","������Ӱ");
			fresh.put("director", "��������");
			fresh.put("cast", "������ְԱ��");
			dataList.add(fresh);
			//ˢ��ui����
			mSimpleAdapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("tag--", "��ͼ�Ѿ�ֹͣ");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("tag--", "��ָû���뿪��Ļ��������ͼ�ڻ���");
			break;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// �ӿڵķ���
		String str=mListView.getItemAtPosition(position)+"";
		Toast.makeText(this, "��������Ӱ����"+position, Toast.LENGTH_SHORT).show();
		//Log.i("tag--", str);
	}
}
