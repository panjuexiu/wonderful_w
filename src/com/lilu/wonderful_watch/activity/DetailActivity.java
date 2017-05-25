package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends Activity {
	private Button buyBtn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.detail);
		buyBtn=(Button) findViewById(R.id.detail_btn_buy);
		buyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��ת��cinema����
				//Toast.makeText(v.getContext(), "������볡��ѡ��", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getApplicationContext(),CinemaActivity.class);
				startActivity(intent);
			}
		});
	}
}
