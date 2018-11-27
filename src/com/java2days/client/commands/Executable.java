package com.java2days.client.commands;

import com.java2days.blockchain.Blockchain;

public interface Executable {
    void execute(Blockchain blockchain);
}
