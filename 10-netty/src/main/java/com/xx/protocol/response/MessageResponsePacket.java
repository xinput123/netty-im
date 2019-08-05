package com.xx.protocol.response;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-07-31 01:56
 */
public class MessageResponsePacket extends Packet {
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
