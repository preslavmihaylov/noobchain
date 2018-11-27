package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.blockchain.Transaction;
import com.java2days.client.annotations.Command;

import java.util.List;

@Command("show pending")
public class ShowPendingCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        List<Transaction> txs = blockchain.getPendingTransactions();
        for (Transaction tx : txs) {
            System.out.println(tx);
        }
    }
}
