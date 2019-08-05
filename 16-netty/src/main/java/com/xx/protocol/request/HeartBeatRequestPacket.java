package com.xx.protocol.request;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.HEARTBEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
