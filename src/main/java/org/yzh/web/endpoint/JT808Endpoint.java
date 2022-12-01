package org.yzh.web.endpoint;

import io.github.yezhihao.netmc.core.annotation.Endpoint;
import io.github.yezhihao.netmc.core.annotation.Mapping;
import io.github.yezhihao.netmc.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.t808.*;
import org.yzh.web.model.enums.SessionKey;
import org.yzh.web.model.entity.DeviceDO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.yzh.protocol.commons.JT808.*;

@Endpoint
@Component
public class JT808Endpoint {

    private static final Logger log = LoggerFactory.getLogger(JT808Endpoint.class.getSimpleName());

    @Mapping(types = 终端通用应答, desc = "终端通用应答")
    public Object generalResponse(T0001 message, Session session) {
        session.response(message);
        return null;
    }

    @Mapping(types = 终端心跳, desc = "终端心跳")
    public void heartbeat(JTMessage message, Session session) {
    }

    @Mapping(types = 终端注销, desc = "终端注销")
    public void unregister(JTMessage message, Session session) {
        session.invalidate();
    }

    @Mapping(types = 查询服务器时间, desc = "查询服务器时间")
    public T8004 serverTime(JTMessage message, Session session) {
        T8004 result = new T8004(LocalDateTime.now(ZoneOffset.UTC));
        return result;
    }

    @Mapping(types = 终端注册, desc = "终端注册")
    public T8100 register(T0100 message, Session session) {
        session.register(message);
        DeviceDO device = new DeviceDO();
        device.setDeviceId(message.getDeviceId());
        device.setMobileNo(message.getClientId());
        device.setPlateNo(message.getPlateNo());
        session.setAttribute(SessionKey.Device, device);

        T8100 result = new T8100();
        result.setResponseSerialNo(message.getSerialNo());
        result.setToken(message.getDeviceId() + "," + message.getPlateNo());
        result.setResultCode(T8100.Success);
        return result;
    }

    @Mapping(types = 终端鉴权, desc = "终端鉴权")
    public T0001 authentication(T0102 message, Session session) {
        session.register(message);
        DeviceDO device = new DeviceDO();
        String[] token = message.getToken().split(",");
        device.setMobileNo(message.getClientId());
        device.setDeviceId(token[0]);
        if (token.length > 1)
            device.setPlateNo(token[1]);
        session.setAttribute(SessionKey.Device, device);

        T0001 result = new T0001();
        result.setResponseSerialNo(message.getSerialNo());
        result.setResponseMessageId(message.getMessageId());
        result.setResultCode(T0001.Success);
        return result;
    }

    @Mapping(types = 位置信息汇报, desc = "位置信息汇报")
    public void locationReport(T0200 list) {

    }
}