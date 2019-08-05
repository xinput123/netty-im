package com.xx.util;

import com.xx.attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-07-31 02:01
 */
public class LoginUtils {

    /**
     * 设置登录标志位
     *
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        // 在登录成功之后，我们通过给 channel 打上属性标记的方式，标记这个 channel 已成功登录
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 判断是否有标志位
     *
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }

}
