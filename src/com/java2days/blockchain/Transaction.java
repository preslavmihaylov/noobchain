package com.java2days.blockchain;

public class Transaction {
    private String sender;
    private String recipient;
    private int amount;

    public Transaction(String sender, String recipient, int amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("{sender: %s, recipient: %s, amount: %s}", sender, recipient, amount);
    }
}
