package com.xx.protocol.request;


import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.LOGOUT_REQUEST;

public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
