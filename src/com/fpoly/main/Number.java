package com.fpoly.main;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpoly.db.Mydatabase;
import com.fpoly.englishfunforkid.R;
import com.fpoly.object.English;

@SuppressLint("NewApi")
public class Number extends Fragment {
	int stt = 0;
	int s;
	Activity root;
	Mydatabase mydb;
	ImageView IvPrevious, IvList, IvRepeat, IvNext, IvNumber;
	TextView textOnOff;
	int nextImageIndex;
	private SQLiteDatabase database;
	ArrayList<English> list = new ArrayList<English>();
	ArrayList<Integer> arrImg = new ArrayList<Integer>();

	public Number() {
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = getActivity();

		nextImageIndex = ListImageNumber.length;
		for (int i = 0; i < nextImageIndex; i++) {
			arrImg.add(ListImageNumber[i]);
		}
		
		View rootView = inflater.inflate(R.layout.screen_number, container,
				false);
		
		mydb = new Mydatabase(root.getApplicationContext());
		
		list = mydb.GetAllInEnglish();
		Log.d("------raa", list.size() + "");
		init(rootView);

		return rootView;
	}

	int ListImageNumber[] = { R.drawable.pack1d1, R.drawable.pack1d2,
			R.drawable.pack1d3, R.drawable.pack1d4, R.drawable.pack1d5,
			R.drawable.pack1d6, R.drawable.pack1d7, R.drawable.pack1d8,
			R.drawable.pack1d9, R.drawable.pack1d10, R.drawable.pack1d11,
			R.drawable.pack1d12, R.drawable.pack1d13, R.drawable.pack1d14,
			R.drawable.pack1d15, R.drawable.pack1d16, R.drawable.pack1d17,
			R.drawable.pack1d18, R.drawable.pack1d19, R.drawable.pack1d20, };

	public void init(View rootView) {
		IvPrevious = (ImageView) rootView.findViewById(R.id.IvPrevious);
		IvList = (ImageView) rootView.findViewById(R.id.IvList);
		IvRepeat = (ImageView) rootView.findViewById(R.id.IvRepeat);
		IvNext = (ImageView) rootView.findViewById(R.id.IvNext);
		IvNumber = (ImageView) rootView.findViewById(R.id.IvNumber);
		textOnOff = (TextView) rootView.findViewById(R.id.textOnOff);
		showCauhoi(1);
		IvNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				stt++;
//				if (stt == 21)

//				{
//					stt = 1;
//				}
				showCauhoi(stt);
			}
		});
		IvPrevious.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				stt--;
				if(stt == -1)
				{
					stt = 20;
				}
				showCauhoi(stt);
				
			}
		});

	}
	

	public void ShowImage(int nameImage) {
		IvNumber.setImageResource(arrImg.get(nameImage));
		

	}

	public void showCauhoi(int stt) {
		English english = new English();
		english = list.get(stt - 1);
		textOnOff.setText(english.getDecription());
		ShowImage(stt - 1);
		

	}
}