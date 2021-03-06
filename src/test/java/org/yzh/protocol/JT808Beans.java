package org.yzh.protocol;

import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.transform.AttributeKey;
import org.yzh.protocol.commons.transform.attribute.InOutAreaAlarm;
import org.yzh.protocol.commons.transform.attribute.OverSpeedAlarm;
import org.yzh.protocol.commons.transform.attribute.RouteDriveTimeAlarm;
import org.yzh.protocol.commons.transform.attribute.TirePressure;
import org.yzh.protocol.t808.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * JT/T 808协议单元测试数据
 * @author yezhihao
 * https://gitee.com/yezhihao/jt808-server
 */
public class JT808Beans {

    public static final String DEVICE_ID = "09876543210987654321";
    public static final String STR_TIME = "200707192359";

    /** 2013版消息头 */
    public static <T extends JTMessage> T H2013(T message) {
        int messageId = message.reflectMessageId();
        if (messageId != 0) message.setMessageId(messageId);
        message.setClientId("123456789012");
        message.setSerialNo(Short.MAX_VALUE);
        message.setEncryption(0);
        message.setReserved(false);
        return message;
    }

    /** 2019版消息头 */
    public static <T extends JTMessage> T H2019(T message) {
        int messageId = message.reflectMessageId();
        if (messageId != 0) message.setMessageId(messageId);
        message.setProtocolVersion(1);
        message.setClientId("12345678901234567890");
        message.setSerialNo(65535);
        message.setEncryption(0);
        message.setVersion(true);
        message.setReserved(false);
        return message;
    }

    //终端通用应答|平台通用应答
    public static T0001 T0001() {
        T0001 bean = new T0001();
        bean.setResponseSerialNo(123);
        bean.setResponseMessageId(456);
        bean.setResultCode(3);
        return bean;
    }

    //终端注册
    public static T0100 T0100() {
        T0100 bean = new T0100();
        bean.setProvinceId(31);
        bean.setCityId(115);
        bean.setMakerId("yzh");
        bean.setDeviceModel("www.jtt808.cn");
        bean.setDeviceId(DEVICE_ID);
        bean.setPlateColor(1);
        bean.setPlateNo("测A888888");
        return bean;
    }

    //终端鉴权
    public static T0102 T0102_2013() {
        T0102 bean = new T0102();
        bean.setToken("pmYGzGukO8K4Z5lpIOTg8dqb3eprYaHBbXSPLtdbyG8=");
        return bean;
    }

    public static T0102 T0102_2019() {
        T0102 bean = new T0102();
        bean.setToken("pmYGzGukO8K4Z5lpIOTg8dqb3eprYaHBbXSPLtdbyG8=");
        bean.setImei("123456789012345");
        bean.setSoftwareVersion("www.jtt808.cn");
        return bean;
    }

    //查询终端属性应答
    public static T0107 T0107() {
        T0107 bean = new T0107();
        bean.setDeviceType(127);
        bean.setMakerId("yzh");
        bean.setDeviceModel("www.jtt808.cn");
        bean.setDeviceId(DEVICE_ID);
        bean.setIccid("12345678901234567890");
        bean.setFirmwareVersion("www.jtt808.cn");
        bean.setHardwareVersion("www.jtt808.cn");
        bean.setGnssAttribute(127);
        bean.setNetworkAttribute(127);
        return bean;
    }


    //位置信息汇报
    public static T0200 T0200() {
        T0200 bean = new T0200();
        bean.setWarnBit(1024);
        bean.setStatusBit(2048);
        bean.setLatitude(116307629);
        bean.setLongitude(40058359);
        bean.setAltitude(312);
        bean.setSpeed(3);
        bean.setDirection(99);
        bean.setDateTime(STR_TIME);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200_() {
        T0200 bean = new T0200();
        bean.setWarnBit(1024 * 2);
        bean.setStatusBit(2048 * 2);
        bean.setLatitude(116307629 * 2);
        bean.setLongitude(40058359 * 2);
        bean.setAltitude(312 * 2);
        bean.setSpeed(3 * 2);
        bean.setDirection(99 * 2);
        bean.setDateTime(STR_TIME);
        return bean;
    }

    //位置信息汇报
    public static T0200 T0200Attributes() {
        T0200 bean = T0200();
        Map<Integer, Object> attributes = new TreeMap<>();
        attributes.put(AttributeKey.Mileage, 11L);
        attributes.put(AttributeKey.Gas, 22);
        attributes.put(AttributeKey.Speed, 33);
        attributes.put(AttributeKey.AlarmEventId, 44);
        attributes.put(AttributeKey.TirePressure, new TirePressure(new byte[]{55, 55, 55}));
        attributes.put(AttributeKey.CarriageTemperature, 2);

        attributes.put(AttributeKey.OverSpeedAlarm, new OverSpeedAlarm((byte) 66, 66));
        attributes.put(AttributeKey.InOutAreaAlarm, new InOutAreaAlarm((byte) 77, 77, (byte) 77));
        attributes.put(AttributeKey.RouteDriveTimeAlarm, new RouteDriveTimeAlarm(88, 88, (byte) 88));

        attributes.put(AttributeKey.Signal, 99);
        attributes.put(AttributeKey.IoState, 10);
        attributes.put(AttributeKey.AnalogQuantity, 20);
        attributes.put(AttributeKey.SignalStrength, 30);
        attributes.put(AttributeKey.GnssCount, 40);
        bean.setAttributes(attributes);
        return bean;
    }


    //终端注册应答
    public static T8100 T8100() {
        T8100 bean = new T8100();
        bean.setResponseSerialNo(38668);
        bean.setResultCode(T8100.Success);
        bean.setToken("chwD0SE1fchwD0SE1fchwD0SE1f");
        return bean;
    }
}