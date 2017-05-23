package com.lilu.wonderful_watch.fragment;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MailMainTabFragment extends Fragment {
	private Button mailSignBtn;
	private Button mailLoginBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mail, container, false);
		//mail×¢²á
		mailSignBtn=(Button) view.findViewById(R.id.mail_btn_register);
		mailSignBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		//mailµÇÂ¼
		mailLoginBtn=(Button) view.findViewById(R.id.mail_btn_login);
		mailLoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		return view;
	}
}
