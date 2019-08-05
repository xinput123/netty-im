package com.xx.protocol.request;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.GROUP_MESSAGE_REQUEST;

public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket() {
    }

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    public String getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(String toGroupId) {
        this.toGroupId = toGroupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
