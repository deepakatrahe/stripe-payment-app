package com.example.stripepayment.dto;

public class PaymentInfo {
    private int amount;
    private String currency;

    public PaymentInfo(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
