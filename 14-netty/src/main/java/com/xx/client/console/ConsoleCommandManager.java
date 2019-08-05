package com.xx.client.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channnel) {
        // 获取第一个指定
        String commond = scanner.next();

        ConsoleCommand consoleCommand = consoleCommandMap.get(commond);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channnel);
        } else {
            System.err.println("无法识别[" + commond + "]指令，请重新输入.");
        }
    }
}
