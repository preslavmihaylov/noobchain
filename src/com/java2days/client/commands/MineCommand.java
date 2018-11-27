package com.java2days.client.commands;

import com.java2days.blockchain.*;
import com.java2days.client.annotations.Command;

import java.util.List;

@Command("mine")
public class MineCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        BlockCandidate blockCandidate = blockchain.getMiningJob();
        String prevBlockHash = blockCandidate.getPrevBlockHash();
        List<Transaction> transactions = blockCandidate.getTransactions();

        int nonce = 0;
        String calculatedBlockHash = "";
        long miningStart = System.nanoTime();

        System.out.println("Mining block...");
        while (!Utils.startsWithZeroes(calculatedBlockHash, blockchain.getDifficulty())) {
            nonce++;

            String blockData = prevBlockHash + transactions.toString() + nonce;
            calculatedBlockHash = Utils.calculateSHA256(blockData);
        }

        long miningEnd = System.nanoTime();
        System.out.printf("Mined block for %.02fs\n", (miningEnd - miningStart) / 1_000_000_000.0);
        System.out.printf("BLOCK_HASH: %s\n", calculatedBlockHash);

        Block newBlock = new Block(transactions, nonce, prevBlockHash, calculatedBlockHash);
        blockchain.submitBlock(newBlock);
    }
}
