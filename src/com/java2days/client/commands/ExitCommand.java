package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

@Command("exit")
public class ExitCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
        System.exit(0);
    }
}
