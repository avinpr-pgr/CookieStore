package com.hacksu.CookieStore.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.hacksu.CookieStore.R;
import com.hacksu.CookieStore.MockData.CartItems;

public class CartFragment extends Fragment {

	protected LayoutInflater layoutInflater;
	protected Button submitButton;
	protected MyReceiver r;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater
				.inflate(R.layout.cart_layout, container, false);

		submitButton = (Button) rootView.findViewById(R.id.cart_submit);
		submitButton.setOnClickListener(submitButtonClickListener);
		r = new MyReceiver();
		LocalBroadcastManager.getInstance(getActivity()).registerReceiver(r,
				new IntentFilter("CART_TAB_REFRESH"));
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		ListView listView = (ListView) getActivity().findViewById(
				R.id.cart_list);
		listView.setAdapter(new CartAdapter(getActivity(), CartItems
				.GetCartItems(getActivity())));
	}

	public void refresh() {
		if (CartItems.GetCartItems(getActivity()).isEmpty()) {
			submitButton.setEnabled(false);
		} else {
			submitButton.setEnabled(true);
		}
	}

	protected View.OnClickListener submitButtonClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			ViewPager viewPager = (ViewPager) getActivity().findViewById(
					R.id.pager);
			viewPager.setCurrentItem(2);
		}
	};

	private class MyReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			CartFragment.this.refresh();
		}
	}
}
