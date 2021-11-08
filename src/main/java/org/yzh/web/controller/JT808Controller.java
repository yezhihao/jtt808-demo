package org.yzh.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yzh.commons.model.APIResult;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;
import org.yzh.protocol.t808.T0001;
import org.yzh.protocol.t808.T0104;
import org.yzh.protocol.t808.T0107;
import org.yzh.web.endpoint.MessageManager;

@RestController
@RequestMapping("terminal")
public class JT808Controller {

    @Autowired
    private MessageManager messageManager;

    @Operation(summary = "8104 8106 查询终端参数")
    @GetMapping("parameters")
    public APIResult<T0104> getParameters(@Parameter(description = "终端手机号") @RequestParam String clientId) {
        JTMessage request = new JTMessage(JT808.查询终端参数);
        T0104 response = messageManager.request(clientId, request, T0104.class);
        return APIResult.ok(response);
    }

    @Operation(summary = "8107 查询终端属性")
    @GetMapping("attributes")
    public APIResult<T0107> getAttributes(@Parameter(description = "终端手机号") @RequestParam String clientId) {
        T0107 response = messageManager.request(clientId, new JTMessage(JT808.查询终端属性), T0107.class);
        return APIResult.ok(response);
    }

    @Operation(summary = "8204 服务器向终端发起链路检测请求")
    @PostMapping("link_detection")
    public APIResult<T0001> link_detection(@RequestParam("clientId") String clientId) {
        T0001 response = messageManager.request(clientId, new JTMessage(JT808.服务器向终端发起链路检测请求), T0001.class);
        return APIResult.ok(response);
    }
}