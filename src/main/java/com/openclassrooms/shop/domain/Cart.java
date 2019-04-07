package com.openclassrooms.shop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
	
     public List<CartLine> cartLines = new ArrayList<>(); 
    /**
     *
     * @return the actual cartline list
     */
    public List<CartLine> getCartLineList() {
        return cartLines;
    }

    /**
     * Adds a getProductById in the cart or increment its quantity in the cart if already added
     * @param product getProductById to be added
     * @param quantity the quantity
     */
    public void addItem(Product product, int quantity) {
        // TODO implement the method
    	for (int i = 0; i < cartLines.size(); i++) {
    		CartLine cartLine = cartLines.get(i);
    		if(cartLine.getProduct().equals(product)) {
    			cartLine.setQuantity(cartLine.getQuantity() + quantity);
    			return;
    		}
    	}
    	CartLine newCartLine = new CartLine(product , quantity);
    	cartLines.add(newCartLine);
       //Implemeted method for addItem
    }

    /**
     * Removes a getProductById form the cart
     * @param product the getProductById to be removed
     */
    public void removeLine(Product product) {
        getCartLineList().removeIf(l -> l.getProduct().getId().equals(product.getId()));
    }


    /**
     * @return total value of a cart
     */
    public double getTotalValue()
    {
         //TODO implement the method
    	double totalValue = 0;
    	
    	for (int i = 0; i < cartLines.size(); i++) {
    		CartLine cartLine = cartLines.get(i);
    		Product cartLineProduct = cartLine.getProduct();
    		totalValue += cartLineProduct.getPrice() * cartLine.getQuantity();
    	}
        return totalValue;
        //Implemented method for getTotalValue
    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue()
    {
        // TODO implement the method
    	double quantity = 0;
    	
    	for (int i = 0; i < cartLines.size(); i++) {
    	CartLine cartLine = cartLines.get(i);
    	quantity += cartLine.getQuantity();
    	}
        return getTotalValue() / quantity;
       //Implemented method for getAverageValue
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    public Product findProductInCartLines(Long productId)
    {
        // TODO implement the method
    	for (int i = 0; i < cartLines.size(); i++) {
    		Product products = cartLines.get(i).getProduct();
    		if(products.getId().equals(productId)){
    			return products;
    		}
    	}
        return null;
       //Implemented method for findProductInCartLines
    }

    /**
     *
     * @param index index of the cartLine
     * @return CartLine in that index
     */
    public CartLine getCartLineByIndex(int index)
    {
        return getCartLineList().get(index);
    }

    /**
     * Clears a the cart of all added products
     */
    public void clear()
    {
        List<CartLine> cartLines = getCartLineList();
        cartLines.clear();
    }
}
