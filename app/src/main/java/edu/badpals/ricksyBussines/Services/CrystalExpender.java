package edu.badpals.ricksyBussines.Services;

import edu.badpals.ricksyBussines.Payments.CreditCard;
import edu.badpals.ricksyBussines.Payments.PaymentMethods;

public class CrystalExpender {

    private Integer stock;
    private Double itemCost = 50d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public void dispatch(PaymentMethods paymentMethod) {
        if(this.stock > 0 && paymentMethod.pay(this.itemCost)){
            this.stock -= 1;
        }
    }

    public Integer getStock() {
        return this.stock;
    }

    @Override
    public String toString() {
        return  "stock: " +this.stock + "\n" +
                "cost: "+ this.itemCost + "\n";
    }
}
