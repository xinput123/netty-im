package com.xx.protocol.request;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    public ListGroupMembersRequestPacket() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
