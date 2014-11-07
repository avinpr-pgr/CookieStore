package com.hacksu.CookieStore.MockData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.hacksu.CookieStore.R;
import com.hacksu.CookieStore.Fragments.CartItem;

public class CartItems {
	private static List<CartItem> cartItems;

	public static List<CartItem> GetCartItems(Context context) {
		String cartList = GetJson(context);
		cartItems = new ArrayList<CartItem>();
		try {
			JSONObject json = new JSONObject(cartList);
			int totalPrice = json.getInt("TotalPrice");
			JSONArray itemList = json.getJSONArray("Items");
			for (int i = 0; i < itemList.length(); i++) {
				CartItem cartItem = new CartItem();
				JSONObject item = (JSONObject) itemList.get(i);
				int id = item.getInt("id");
				String description = item.getString("description");
				int quantity = item.getInt("quantity");
				cartItem.setCartItemName(description);
				cartItem.setCartItemQuantity(quantity);
				cartItems.add(cartItem);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	private static String GetJson(Context context) {
		InputStream is = context.getResources().openRawResource(R.raw.cart);
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception ex) {
			return "";
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String jsonString = writer.toString();
		return jsonString;
	}

	public static boolean DeleteFromCart(int position) {
		if (position + 1 > cartItems.size()) {
			return false;
		} else {
			cartItems.remove(position);
			return true;
		}
	}
}
