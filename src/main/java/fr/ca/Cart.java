package fr.ca;

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
        return products
                .entrySet()
                .stream()
                .map(x -> x.getKey().getPrice() * x.getValue())
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
