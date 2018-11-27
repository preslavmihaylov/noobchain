package com.java2days.client.commands;

import com.java2days.blockchain.Block;
import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

import java.util.List;

@Command("show blocks")
public class ShowBlocksCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        List<Block> blocks = blockchain.getBlockchain();

        int cnt = 0;
        for (Block block : blocks) {
            System.out.println("--------- BLOCK " + cnt + " ---------");
            System.out.println(block);
            System.out.println();

            cnt++;
        }
    }
}
