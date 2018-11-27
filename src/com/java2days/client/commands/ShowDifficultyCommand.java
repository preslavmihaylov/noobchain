package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

@Command("show difficulty")
public class ShowDifficultyCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        System.out.println(blockchain.getDifficulty());
    }
}
