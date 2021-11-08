package org.yzh.protocol;

import org.junit.jupiter.api.Test;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;

import static org.yzh.protocol.BeanTest.*;
import static org.yzh.protocol.JT808Beans.*;

/**
 * JT/T 808协议单元测试类
 * @author yezhihao
 * @home https://gitee.com/yezhihao/jt808-server
 */
public class JT808BeansTest {

    @Test
    public void testT0001() {
        selfCheck(H2013(T0001()));
        selfCheck(H2019(T0001()));
    }

    @Test
    public void testT0002() {
        JTMessage message = new JTMessage();
        message.setMessageId(JT808.终端心跳);
        selfCheck(H2013(message));
        selfCheck(H2019(message));
    }

    @Test
    public void testT0200() {
        selfCheck(H2013(T0200Attributes()));
        selfCheck(H2019(T0200Attributes()));
    }

    @Test
    public void testT0100() {
        selfCheck(H2013(T0100()));
        selfCheck(H2019(T0100()));
    }

    @Test
    public void testT0107() {
        selfCheck(H2013(T0107()));
        selfCheck(H2019(T0107()));
    }

    @Test
    public void testT0102() {
        selfCheck(H2013(T0102_2013()));
        selfCheck(H2019(T0102_2019()));
    }

    @Test
    public void testT8100() {
        selfCheck(H2013(T8100()));
        selfCheck(H2019(T8100()));
    }
}