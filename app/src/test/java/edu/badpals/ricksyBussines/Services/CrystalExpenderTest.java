package edu.badpals.ricksyBussines.Services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import edu.badpals.ricksyBussines.Payments.CreditCard;

public class CrystalExpenderTest {

    private CrystalExpender expender = null;


    public void setupExpender() {
        expender = new CrystalExpender(100, 50.0);
        assertNotNull(expender);
    }

    @Test
    public void constructortest() {
        setupExpender();
        assertNotNull(expender);
        assertEquals(100, expender.getStock());
    }

    @Test
    public void dispatchTestOK() {
        setupExpender();
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender.dispatch(card);
        assertEquals(99, expender.getStock());
    }

    @Test
    public void dispatchTestNoStock() {
        setupExpender();
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new CrystalExpender(0, 50.0);
        expender.dispatch(card);
        assertEquals(0, expender.getStock());
        assertEquals(3000, card.getCredit(), 0);
    }

    @Test
    public void dispatchTestNoCredit() {
        setupExpender();
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        expender = new CrystalExpender(100, 4000);
        expender.dispatch(card);
        assertEquals(100, expender.getStock());
    }
}
