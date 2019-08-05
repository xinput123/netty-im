package com.xx.protocol.response;

import com.xx.protocol.Packet;

import static com.xx.protocol.command.Command.LOGOUT_RESPONSE;

public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
