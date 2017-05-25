package com.lilu.wonderful_watch.activity;

import java.util.ArrayList;
import java.util.List;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.fragment.CellMainTabFragment;
import com.lilu.wonderful_watch.fragment.MailMainTabFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpActivity extends FragmentActivity {
	//��������
	private ViewPager mViewPager;
	private FragmentPagerAdapter mPagerAdapter;
	private List<Fragment> mData=new ArrayList<Fragment>();
	private TextView cellTv;
	private TextView mailTv;
	private int mHalf;
	private ImageView mHalfScreen;
	private int mCurrentPageIndex;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.signup);
		initTabLine();
		initView();
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
	//ע��--sign up
	protected void resetTextColor() {
		// TODO Auto-generated method stub
		cellTv.setTextColor(Color.BLACK);
		mailTv.setTextColor(Color.BLACK);
	}
}
