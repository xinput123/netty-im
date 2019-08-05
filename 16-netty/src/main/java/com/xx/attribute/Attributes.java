package com.xx.attribute;

import com.xx.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
