package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

@Command("reset")
public class ResetCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        blockchain.reset();
    }
}
