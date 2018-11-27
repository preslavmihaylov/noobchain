package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

@Command("increase difficulty")
public class IncreaseDifficultyCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        blockchain.setDifficulty(blockchain.getDifficulty() + 1);
        System.out.printf("Blockchain difficulty increased. Difficulty is now %d\n",
                blockchain.getDifficulty());
    }
}
