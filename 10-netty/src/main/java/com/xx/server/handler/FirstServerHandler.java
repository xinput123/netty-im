package com.xx.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 服务端收到数据之后，仅仅把数据打印出来
 * <p>
 * 从服务端的控制台输出可以看出，存在三种类型的输出：
 * 1、一种是正常的字符串输出。
 * 2、一种是多个字符串“粘”在了一起，我们定义这种 ByteBuf 为粘包。
 * 3、一种是一个字符串被“拆”开，形成一个破碎的包，我们定义这种 ByteBuf 为半包。
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "你好，欢迎!".getBytes(Charset.forName("utf-8"));

        ByteBuf buffer = ctx.alloc().buffer();

        buffer.writeBytes(bytes);

        return buffer;
    }
}
