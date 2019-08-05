package com.xx.protocol.request;


import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.JOIN_GROUP_REQUEST;

public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
