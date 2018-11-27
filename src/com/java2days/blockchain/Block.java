package com.java2days.blockchain;

import java.util.List;

public class Block {
    private final List<Transaction> transactions;
    private final long nonce;
    private final String prevBlockHash;
    private final String blockHash;

    public Block(List<Transaction> transactions, int nonce, String prevBlockHash, String blockHash) {
        this.transactions = transactions;
        this.nonce = nonce;
        this.prevBlockHash = prevBlockHash;
        this.blockHash = blockHash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public long getNonce() {
        return nonce;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    @Override
    public String toString() {
        System.out.println("transactions:");
        for (Transaction transaction : transactions) {
            System.out.printf("\t%s\n", transaction);
        }

        return String.format("nonce: %d\nprv_blockhash: %s\nblockhash: %s",
                nonce,
                prevBlockHash,
                blockHash);
    }
}
