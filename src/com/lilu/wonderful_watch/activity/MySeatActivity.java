package com.lilu.wonderful_watch.activity;

import java.util.ArrayList;
import java.util.HashSet;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.listener.OnSeatClickListener;
import com.lilu.wonderful_watch.model.Seat;
import com.lilu.wonderful_watch.model.SeatInfo;
import com.lilu.wonderful_watch.view.SSThumView;
import com.lilu.wonderful_watch.view.SSView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MySeatActivity extends Activity {
	
	public static HashSet<String> hs = new HashSet<String>();
	
	private TextView movieNameTextView;
	private TextView cinemaNameTextView;
	private TextView movieTimeTextView;
	private TextView movieLanguageTextView;
	private TextView priceTextView;
	
	private Button confirmPay;
	private ImageButton backImageButton;
	
	public static String movieName;
	public static String movieTime;
	public static String cinemaName;
	private String movieLanguage;
	
	private int price = 0;
	private int singlePrice = 30;
	
	private int currentPay;
	
	private static final int ROW = 20;
	private static final int EACH_ROW_COUNT =30;
	private SSView mSSView;
	private SSThumView mSSThumView;
	private ArrayList<SeatInfo> list_seatInfos = new ArrayList<SeatInfo>();
	private ArrayList<ArrayList<Integer>> list_seat_conditions = new ArrayList<ArrayList<Integer>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seat);
		movieName = getIntent().getStringExtra("movieName");
		cinemaName = getIntent().getStringExtra("cinemaName");
		movieTime = getIntent().getStringExtra("time");
		movieLanguage =  getIntent().getStringExtra("movieLanguage");
		if (hs.size() >= 1) {
			hs.clear();
		}
		init();
	}
	
	
	private void init(){
		movieNameTextView = (TextView) findViewById(R.id.seat_tv_film);
		cinemaNameTextView = (TextView) findViewById(R.id.seat_tv_cinema);
		movieTimeTextView = (TextView) findViewById(R.id.seat_tv_time);
		movieLanguageTextView = (TextView) findViewById(R.id.seat_tv_language);
		priceTextView = (TextView) findViewById(R.id.seat_tv_pric);
		confirmPay = (Button) findViewById(R.id.seat_btn_lock);
		backImageButton = (ImageButton) findViewById(R.id.seat_ib_back);
		movieNameTextView.setText(movieName);
		movieTimeTextView.setText(movieTime);
		cinemaNameTextView.setText(cinemaName);
		movieLanguageTextView.setText(movieLanguage);
		priceTextView.setText("0");
		mSSView = (SSView)this.findViewById(R.id.mSSView);
		mSSThumView = (SSThumView)this.findViewById(R.id.ss_ssthumview);
//		mSSView.setXOffset(20);
		setSeatInfo();
		mSSView.init(EACH_ROW_COUNT, ROW, list_seatInfos, list_seat_conditions, mSSThumView, 5);
		mSSView.setOnSeatClickListener(new OnSeatClickListener() {
			
			@Override
			public boolean b(int column_num, int row_num, boolean paramBoolean) {
				hs.add((row_num+1)+"排 " + (column_num+1) +"列");
				//String desc =  "您选择了第"+(row_num+1)+"排" + " 第" + (column_num+1) +"列";
				//Toast.makeText(MySeatActivity.this,desc.toString(), Toast.LENGTH_SHORT).show();
				runOnUiThread(new Runnable() {
					public void run() {
						currentPay = (price + 1) * singlePrice;
						priceTextView.setText(currentPay + "");
						price ++;
					}
				});
				return false;
			}
			
			@Override
			public boolean a(int column_num, int row_num, boolean paramBoolean) {
//				String desc =  "您取消了第"+(row_num+1)+"排" + " 第" + (column_num+1) +"列";
//				Toast.makeText(MySeatActivity.this,desc.toString(), Toast.LENGTH_SHORT).show();
				runOnUiThread(new Runnable() {
					public void run() {
						currentPay = (price - 1) * singlePrice;
						priceTextView.setText(currentPay + "");
						price--;
					}
				});
				return false;
			}
			
			@Override
			public void a() {
				// TODO Auto-generated method stub
				
			}
		});
		confirmPay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (currentPay == 0) {
					Toast.makeText(MySeatActivity.this,"您还没有进行选座！".toString(), Toast.LENGTH_SHORT).show();
					return;
				} else {
					Intent intent = new Intent(v.getContext(), PayActivity.class);
					intent.putExtra("movieName", movieName);
					intent.putExtra("cinemaName", cinemaName);
					intent.putExtra("time", movieTime);
					intent.putExtra("movieLanguage", movieLanguage);
					intent.putExtra("movieLocation", hs.toString());
					intent.putExtra("currentPay", currentPay + "");
					startActivity(intent);
				}
			}
		});
		backImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				MySeatActivity.this.finish();
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
	
	private void setSeatInfo(){
		for(int i =0;i<ROW;i++){//8行
			SeatInfo mSeatInfo = new SeatInfo();
			ArrayList<Seat> mSeatList = new ArrayList<Seat>();
			ArrayList<Integer> mConditionList = new ArrayList<Integer>();
			for(int j=0;j<EACH_ROW_COUNT;j++){//每排20个座位
				Seat mSeat = new Seat();
				if(j<3){
					mSeat.setN("Z");
					mConditionList.add(0);
				}else{
					mSeat.setN(String.valueOf(j-2));
					if(j>10){
						mConditionList.add(1);
					}else{
						mConditionList.add(1);
					}
					
				}
				mSeat.setDamagedFlg("");
				mSeat.setLoveInd("0");
				mSeatList.add(mSeat);
			}
			mSeatInfo.setDesc(String.valueOf(i+1));
			mSeatInfo.setRow(String.valueOf(i+1));
			mSeatInfo.setSeatList(mSeatList);
			list_seatInfos.add(mSeatInfo);
			list_seat_conditions.add(mConditionList);
		}
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
