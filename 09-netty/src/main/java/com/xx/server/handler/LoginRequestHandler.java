package com.xx.server.handler;

import com.xx.protocol.request.LoginRequestPacket;
import com.xx.protocol.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * 我们处理Java对象逻辑的时候
 * if (packet instanceof XXXPacket) {
 * // ...处理
 * } else {
 * ctx.fireChannelRead(packet);
 * }
 * 我们通过 if...else... 逻辑进行逻辑的处理，当我们处理逻辑越来乐队的时候，代码会显得越来越臃肿，
 * 我们可以通过给 pipeline 添加多个 handler(ChannelInboundHandlerAdapter的子类)来解决过多
 * 的 if...else...问题
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
