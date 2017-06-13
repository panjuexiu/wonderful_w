package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PayActivity extends Activity {
	
	private TextView movieTitle;
	
	private TextView movieNameTextView;
	private TextView cinemaNameTextView;
	private TextView movieTimeTextView;
	private TextView movieLanguageTextView;
	private TextView movieLocationTextView;
	private TextView priceTextView;
	
	private ImageButton backImageButton;
	
	private Button payButton;
	
	private String movieName;
	private String movieTime;
	private String cinemaName;
	private String movieLanguage;	
	private String movieLocation;
	private String currentPay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pay);

		movieName = getIntent().getStringExtra("movieName");
		cinemaName = getIntent().getStringExtra("cinemaName");
		movieTime = getIntent().getStringExtra("time");
		movieLanguage =  getIntent().getStringExtra("movieLanguage");
		movieLocation =  getIntent().getStringExtra("movieLocation");
		currentPay =  getIntent().getStringExtra("currentPay");
		
		initData();
		setListener();
	}

	private void setListener() {
		backImageButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PayActivity.this.finish();
			}
		});
		payButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), WayActivity.class);
				startActivity(intent);
			}
		});
	}

	private void initData() {
		movieTitle = (TextView) findViewById(R.id.pay_tv_film_title);
		backImageButton = (ImageButton) findViewById(R.id.pay_ib_back);
		movieNameTextView = (TextView) findViewById(R.id.pay_tv_film);
		cinemaNameTextView = (TextView) findViewById(R.id.pay_tv_cinema);
		movieTimeTextView = (TextView) findViewById(R.id.pay_tv_time);
		movieLanguageTextView = (TextView) findViewById(R.id.pay_tv_language);
		movieLocationTextView = (TextView) findViewById(R.id.pay_tv_seat);
		priceTextView = (TextView) findViewById(R.id.pay_tv_pric);
		payButton = (Button) findViewById(R.id.pay_btn_pay);
		
		movieTitle.setText(movieName);
		movieNameTextView.setText(movieName);
		cinemaNameTextView.setText(cinemaName);
		movieTimeTextView.setText(movieTime);
		movieLanguageTextView.setText(movieLanguage);
		movieLocationTextView.setText(movieLocation);
		priceTextView.setText(currentPay);
	}
	
	
}
