package com.xx.codec;

import com.xx.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

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
