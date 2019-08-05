package com.xx.protocol.response;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-07-31 01:56
 */
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

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

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
}
