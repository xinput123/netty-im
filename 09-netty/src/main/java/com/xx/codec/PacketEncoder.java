package com.xx.codec;

import com.xx.protocol.Packet;
import com.xx.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * MessageToByteEncoder : 将对象转换到二进制数据
 * <p>
 * PacketEncoder 继承自 MessageToByteEncoder，
 * 泛型参数 Packet 表示这个类的作用是实现 Packet 类型对象到二进制的转换
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * 把 Java 对象里面的子弹写到 ByteBuf，这样我就不用自行去分配 BygeBuf
     *
     * @param ctx
     * @param packet : Java 对象
     * @param out    : ByteBuf 对象
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, packet);
    }
}
