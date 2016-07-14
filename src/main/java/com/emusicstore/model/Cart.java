package com.emusicstore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;
	
	private Cart(){
		setCartItems(new HashMap<String, CartItem>());
		setGrandTotal(0.0);
	}
	
	public Cart(String cartId){
		this();
		this.setCartId(cartId);
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	
	public void addCartItem(CartItem item){
		String productId = item.getProduct().getProductId();
		
		if(cartItems.containsKey(productId)){
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
			cartItems.put(productId,  existingCartItem);
		}else{
			cartItems.put(productId, item);
		}
		
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item){
		String productId = item.getProduct().getProductId();
		cartItems.remove(productId);
		updateGrandTotal();
	}
	
	public void updateGrandTotal(){
		grandTotal= 0;
		for(CartItem item : cartItems.values() ){
			grandTotal = grandTotal + item.getTotalPrice();
		}
	}
}
