package com.fpoly.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpoly.englishfunforkid.R;

@SuppressLint("NewApi")
public class Fruit extends Fragment {
	Activity root;

	public Fruit() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		root = getActivity();

		View rootView = inflater.inflate(R.layout.screen_fruit, container,
				false);

		return rootView;
	}
}
