
package com.hacksu.CookieStore.Fragments;

public class CartItem {

	private String cartItemName;
	private int cartItemQuantity;
    private double cartItemPrice;
	
	public String getCartItemName() {
		return cartItemName;
	}
	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}
	public int getCartItemQuantity() {
		return cartItemQuantity;
	}
	public void setCartItemQuantity(int cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}
    public double getCartItemPrice() {
        return cartItemPrice;
    }
    public void setCartItemPrice(double cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }
	
}

