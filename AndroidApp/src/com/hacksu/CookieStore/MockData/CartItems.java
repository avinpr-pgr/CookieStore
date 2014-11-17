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
import java.util.concurrent.ExecutionException;

import com.hacksu.CommunicationLibrary.AllProductsApiCall;
import com.hacksu.CommunicationLibrary.DeleteApiCall;
import com.hacksu.CommunicationLibrary.DetailedOrderApiCall;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.hacksu.CookieStore.R;
import com.hacksu.CookieStore.Fragments.CartItem;

public class CartItems {
	private static List<CartItem> cartItems;

	public static List<CartItem> GetCartItems() {
		String cartList = GetJson();
		cartItems = new ArrayList<CartItem>();
		try {
            JSONArray productList = new JSONArray();
            productList = GetProductList();
			JSONArray itemList = new JSONArray(cartList);
			for (int i = 0; i < itemList.length(); i++) {
				CartItem cartItem = new CartItem();
				JSONObject item = (JSONObject) itemList.get(i);
				String description = item.getString("Name");
				int quantity = item.getInt("Quantity");
                double price = 0.00;
                for(int q =0; q < productList.length(); q++)
                {
                    JSONObject product = (JSONObject) productList.get(q);
                    if(product.getString("ProductId") == item.getString("ProductId"))
                    {
                        double priceAmount =  product.getDouble("Price");
                        price = quantity * priceAmount;
                    }
                }
                cartItem.setCartItemPrice(price);
				cartItem.setCartItemName(description);
				cartItem.setCartItemQuantity(quantity);
				cartItems.add(cartItem);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return cartItems;
	}

	private static String GetJson() {
        String urlString = "http://cookieapidev1.cloudapp.net/ksuapi/api/orders/DetailedOrder";
        DetailedOrderApiCall detailedOrder = new DetailedOrderApiCall(urlString);
        detailedOrder.execute();
        String jsonString = "";
        try{
            jsonString = detailedOrder.get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return jsonString;
	}

    private static JSONArray GetProductList() {
        JSONArray data = null;

        String urlString = "http://cookieapidev1.cloudapp.net/ksuapi/api/products/AllProducts";
        AllProductsApiCall client = new AllProductsApiCall(urlString);
        client.execute();
        try
        {
            data = new JSONArray(client.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

	public static boolean DeleteFromCart(int position, int productId) {
        if (position + 1 > cartItems.size()) {
			return false;
		} else {
            try {
                String cartListDelete = GetJson();
                JSONArray itemListDelete = new JSONArray(cartListDelete);
                JSONObject itemDelete = (JSONObject) itemListDelete.get(position);
                productId = itemDelete.getInt("ProductId");
            }
            catch(Exception e)
            {e.printStackTrace();}

            String urlDeleteString = "http://cookieapidev1.cloudapp.net/ksuapi/api/orders/RemoveItem/"+productId;
            DeleteApiCall deleteApiCall= new DeleteApiCall(urlDeleteString);
            deleteApiCall.execute();
			return true;
		}
	}
}
