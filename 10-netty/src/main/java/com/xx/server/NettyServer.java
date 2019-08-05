package com.xx.server;

import com.xx.codec.PacketDecoder;
import com.xx.codec.PacketEncoder;
import com.xx.server.handler.LoginRequestHandler;
import com.xx.server.handler.MessageRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 为什么会有粘包半包现象？
 * <p>
 * 尽管我们在应用层面使用了 Netty，但是对于操作系统来说，只认 TCP 协议，
 * 尽管我们的应用层是按照 ByteBuf 为 单位来发送数据，但是到了底层操作系
 * 统仍然是按照字节流发送数据，因此，数据到了服务端，也是按照字节流的方式
 * 读入，然后到了 Netty 应用层面，重新拼装成 ByteBuf，而这里的 ByteBuf
 * 与客户端按顺序发送的 ByteBuf 可能是不对等的。因此，我们需要在客户端根
 * 据自定义协议来组装我们应用层的数据包，然后在服务端根据我们的应用层的协议
 * 来组装数据包，这个过程通常在服务端称为拆包，而在客户端称为粘包。
 */
public class NettyServer {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
//                        ch.pipeline().addLast(new FirstServerHandler());
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });

        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}
