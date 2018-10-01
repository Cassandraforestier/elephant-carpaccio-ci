package fr.iut;

import fr.ca.Cart;
import fr.ca.Item;
import fr.ca.Tax;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestHtPrice {

    @Test
    public void testItemConstructor() {
        final Item i = new Item("Counter strike", 60.0d);

        assertEquals("Counter strike", i.getLabel());
        assertTrue(60.0d == i.getPrice());
    }

    @Test
    public void testAddProduct() {
        final Item i = new Item("Counter strike", 60.0d);

        final Cart c = new Cart();
        c.addProduct(i, 2);

        assertEquals(1, c.countProducts());
    }

    @Test
    public void testHtPrice() {
        final Item i = new Item("Counter strike", 60.0d);

        final Cart c = new Cart();
        c.addProduct(i, 2);
        c.addProduct(new Item("Tomates", 20.0d), 5);

        assertTrue(220.0d == c.computeHtPrice());

    }

    @Test
    public void testDeTax() {
        final Item i = new Item("Counter strike", 60.0d);

        final Cart c = new Cart();
        c.addProduct(i, 1);

        assertEquals(71.4, c.computeTotalPrice(Tax.DE), 0.01d);
    }
}
