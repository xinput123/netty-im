package com.xx.client.console;

import com.xx.protocol.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-08-04 18:30
 */
public class SendToUserConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
