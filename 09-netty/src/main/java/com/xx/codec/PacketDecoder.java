package com.xx.codec;

import com.xx.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 通常情况下，无论我们是在客户端还是服务端，当我们收到数据之后，首先要做的就是把
 * 二进制数据转换到我们一个Java对象，所有Netty很贴心地写了一个父类，来专门做这个
 * 事情。ByteToMessageDecoder
 * <p>
 * 注：
 * 这里使用了 Netty 4.1.6.Final 版本，默认情况下用的是堆外内存，堆外内存需要我们
 * 自行释放，而这里使用的是 ByteToMessageDecoder，Netty会自动进行内存的释放
 */
public class PacketDecoder extends ByteToMessageDecoder {

    /**
     * @param ctx
     * @param in  第二个参数，表示传入进来的数据，已经是 ByteBuf 类型
     * @param out : 第三个参数是 List 类型，我们通过往这个List里面添加解码后的结果对象，就可以
     *            自动实现结果往下一个 handler 进行传递
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
