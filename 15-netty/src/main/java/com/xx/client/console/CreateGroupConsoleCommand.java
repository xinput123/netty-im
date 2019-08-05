package com.xx.client.console;

import com.xx.protocol.request.CreateGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-08-04 18:31
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {

    private static final String USER_ID_SPLITER = ",";

    @Override
    public void exec(Scanner scanner, Channel channnel) {
        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");

        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        String userIds = scanner.next();

        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channnel.writeAndFlush(createGroupRequestPacket);
    }
}
