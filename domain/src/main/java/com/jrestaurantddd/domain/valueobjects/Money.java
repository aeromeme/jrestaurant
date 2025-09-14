package com.jrestaurantddd.domain.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public final class Money {
    private double amount;
    private String currency;

    protected Money() {
        // For JPA
    }

    public Money(double amount, String currency) {
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
