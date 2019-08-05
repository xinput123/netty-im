package com.xx.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channnel);
}
