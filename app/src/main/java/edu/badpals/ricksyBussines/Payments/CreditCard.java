package edu.badpals.ricksyBussines.Payments;

public class CreditCard implements PaymentMethods {



    final String owner;
    final String number;
    Double credit = 0d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number){
        this.owner = owner;
        this.number = number;
        this.setCredit(3000d);
    }

    @Override
    public boolean pay(Double payment) {
        if (this.getCredit() >= payment){
            this.setCredit(this.getCredit() - payment);
            return true;
        }
        else {
            return false;
        }
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getOwner() {
        return owner;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  "owner: " + this.getOwner()+ "\n"+
                "number: " + this.getNumber()+ "\n"+
                "credit: " + this.getCredit()+ "\n";
    }
}
