package com.java2days.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blocks;
    private List<Transaction> pendingTransactions;
    private int difficulty = 4;

    public Blockchain() {
        this.blocks = new ArrayList<>();
        this.pendingTransactions = new ArrayList<>();

        reset();
    }

    public List<Block> getBlockchain() {
        return new ArrayList<>(blocks);
    }

    public void addPendingTransaction(Transaction tx) {
        pendingTransactions.add(tx);
    }

    public List<Transaction> getPendingTransactions() {
        return new ArrayList<>(pendingTransactions);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void reset() {
        if (blocks == null) {
            blocks = new ArrayList<>();
        }

        blocks.clear();
        blocks.add(new Block(new ArrayList<>(), 0, "GEN", "GEN"));
    }

    public BlockCandidate getMiningJob() {
        String lastBlockHash = blocks.get(blocks.size() - 1).getBlockHash();

        return new BlockCandidate(pendingTransactions, lastBlockHash);
    }

    public void submitBlock(Block newBlock) {
        if (isValidBlock(newBlock)) {
            blocks.add(newBlock);
        } else {
            throw new IllegalArgumentException("Invalid block");
        }
    }

    private boolean isValidBlock(Block block) {
        String prevBlockHash = block.getPrevBlockHash();
        List<Transaction> transactions = block.getTransactions();
        long nonce = block.getNonce();
        String blockHash = block.getBlockHash();

        Block lastBlock = blocks.get(blocks.size() - 1);
        String blockData = prevBlockHash + transactions.toString() + nonce;
        String calculatedBlockHash = Utils.calculateSHA256(blockData);

        return prevBlockHash.equals(lastBlock.getBlockHash()) &&
                calculatedBlockHash.equals(blockHash) &&
                Utils.startsWithZeroes(blockHash, difficulty);
    }
}
