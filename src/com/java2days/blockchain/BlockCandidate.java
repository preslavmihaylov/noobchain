package com.java2days.blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockCandidate {
    private final List<Transaction> transactions;
    private final String prevBlockHash;

    BlockCandidate(List<Transaction> transactions, String prevBlockHash) {
        this.transactions = transactions;
        this.prevBlockHash = prevBlockHash;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }
}
