package com.xx.server.handler;

import com.xx.util.LoginUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 判断一个用户是否登录很简单，只需要调用一下 LoginUtil.hasLogin(channel) 即可，
 * 但是，Netty 的 pipeline 机制帮我们省去了重复添加同一段逻辑的烦恼，我们只需要在
 * 后续所有的指令处理 handler 之前插入一个用户认证 handle：
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    /**
     * AuthHandler 继承自 ChannelInboundHandlerAdapter，覆盖了
     * channelRead() 方法，表明他可以处理所有类型的数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!LoginUtils.hasLogin(ctx.channel())) {
            // 判断是否登录成功，如果未登录，直接强制关闭连接(这里只是开发用，正式环境应该有相对应的处理)
            ctx.channel().close();
        } else {
            // 在客户端第一次发来消息的时候， AuthHandler 判断当前用户已通
            // 过身份认证，直接移除掉自身，移除掉之后，回调 handlerRemoved
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        if (LoginUtils.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
        } else {
            System.out.println("无登录验证，强制关闭连接!");
        }
    }
}
