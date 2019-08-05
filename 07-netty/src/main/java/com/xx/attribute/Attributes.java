package com.xx.attribute;

import io.netty.util.AttributeKey;

/**
 * 如何判断客户端是否已经登录？
 * <p>
 * 我们可以给客户端连接，也就是 Channel 绑定属性，通过
 * channel.attr(xxx).set(xx) 的方式，那么我们是否可以在登录成功之
 * 后，给 Channel 绑定一个登录成功的标志位，然后判断是否登录成功的时候
 * 取出这个标志位就可以了
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
