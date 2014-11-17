package com.hacksu.CookieStore.Fragments;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hacksu.CommunicationLibrary.DetailedOrderApiCall;
import com.hacksu.CookieStore.R;
import com.hacksu.CookieStore.MockData.CartItems;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CartAdapter extends BaseAdapter {

	protected Context context;
	protected List<CartItem> cartItems;
    int productId = 0;

	public CartAdapter(Context context, List<CartItem> cartItems) {
		this.context = context;
		this.cartItems = cartItems;
	}

	@Override
	public int getCount() {
		return cartItems.size();
	}

	@Override
	public Object getItem(int position) {
		return cartItems.indexOf(getItem(position));
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.cart_item, null);
		}

		TextView cartItemName = (TextView) convertView
				.findViewById(R.id.cart_item_name);
		TextView cartItemQuantity = (TextView) convertView
                .findViewById(R.id.cart_item_quantity);
        TextView cartItemPrice = (TextView) convertView
                .findViewById(R.id.cart_item_price);
		Button cartItemDelete = (Button) convertView
				.findViewById(R.id.cart_item_delete);

        String urlString = "http://cookieapidev1.cloudapp.net/ksuapi/api/orders/DetailedOrder";
        DetailedOrderApiCall detailedOrderApiCall = new DetailedOrderApiCall(urlString);
        detailedOrderApiCall.execute();
        String detailList = "";
        try {
            detailList = detailedOrderApiCall.get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JSONArray detailJsonObject = new JSONArray(detailList);
            for (int i = 0; i < detailJsonObject.length(); i++) {
                JSONObject item = (JSONObject) detailJsonObject.get(i);
                if(cartItemName.toString() == item.getString("Name"))
                    productId = item.getInt("ProductId");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        CartItem cartItem = cartItems.get(position);
		cartItemName.setText(cartItem.getCartItemName());
		cartItemQuantity.setText("Qty. " + cartItem.getCartItemQuantity());
        cartItemPrice.setText("Price: $" + cartItem.getCartItemPrice());
		cartItemDelete.setTag(position);
		cartItemDelete.setOnClickListener(deleteClickListener);

		return convertView;
	}

	private View.OnClickListener deleteClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			final int position = (Integer) v.getTag();
			AlertDialog.Builder adb = new AlertDialog.Builder(context);
			adb.setTitle("Delete?");
			adb.setMessage("Are you sure you want to remove item?");
			adb.setNegativeButton("Cancel", null);
			adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					CartItems.DeleteFromCart(position, productId);
					notifyDataSetChanged();
					LocalBroadcastManager lbm = LocalBroadcastManager
							.getInstance(context);
					Intent i = new Intent("CART_TAB_REFRESH");
					lbm.sendBroadcast(i);
				}
			});
			adb.show();
		}
	};
}
