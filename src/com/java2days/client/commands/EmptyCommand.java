package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;
import com.java2days.client.annotations.Command;

@Command("")
public class EmptyCommand implements Executable {
    @Override
    public void execute(Blockchain blockchain) {
    }
}
