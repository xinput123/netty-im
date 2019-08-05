package com.xx.client.console;

import com.xx.protocol.request.LogoutRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-08-04 18:31
 */
public class LogoutConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
