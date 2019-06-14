package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by home on 2019/3/13.
 */
@Component
public
class WebSocketConfig {
    @Bean//测试的时候注释
    public
    ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
