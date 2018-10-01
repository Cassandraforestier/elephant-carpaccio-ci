package fr.ca;

import fr.ca.Item;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Item, Integer> products = new HashMap<Item, Integer>();

    public void addProduct(final Item item, final int quantity) {
        products.put(item, quantity);
    }

    public int countProducts() {
        return products.keySet().size();
    }

    public double computePrice() {
        double totalPrice = 0.0d;

        for (Item i : products.keySet()) {
            totalPrice += (i.getPrice() * products.get(i));
        }

        return totalPrice;
    }
}
