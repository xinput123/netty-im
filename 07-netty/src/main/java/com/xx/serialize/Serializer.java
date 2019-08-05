package com.xx.serialize;

import com.xx.serialize.impl.JSONSerializer;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-07-31 01:20
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
