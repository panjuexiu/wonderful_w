package com.lilu.wonderful_watch.fragment;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CellMainTabFragment extends Fragment {
	private Button cellSignBtn;
	private Button cellLoginBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cell, container, false);
		//cell×¢²á
		cellSignBtn = (Button) view.findViewById(R.id.cell_btn_register);
		cellSignBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		//cellµÇÂ¼
		cellLoginBtn=(Button) view.findViewById(R.id.cell_btn_login);
		cellLoginBtn.setOnClickListener(new OnClickListener() {
			
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
