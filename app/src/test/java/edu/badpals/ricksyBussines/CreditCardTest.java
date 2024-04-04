package edu.badpals.ricksyBussines;

import edu.badpals.ricksyBussines.Payments.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreditCardTest {

    private CreditCard card = null;

    public void setupCard() {
        card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertNotNull(card);
    }

    @Test
    public void constructortest() {
        setupCard();
        assertNotNull(card);
        assertEquals("4916119711304546", card.getNumber());
    }

    @Test
    public void payTestOK() {
        setupCard();
        card.pay(3000d);
        assertEquals(0, card.getCredit(), 0);
    }

    @Test
    public void payTestNOTOK() {
        setupCard();
        card.pay(4000d);
        assertEquals(3000, card.getCredit(), 0);
    }
}