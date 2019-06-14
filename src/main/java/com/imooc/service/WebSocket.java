package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by home on 2019/3/13.
 */
@Component
@ServerEndpoint("/webSocket")//测试的时候注释
@Slf4j
public
class WebSocket {
    private Session session;
    //定义websocket的容器,储存这些session
    private static
    CopyOnWriteArrayList<WebSocket>webSocketSet=new CopyOnWriteArrayList<>();
  @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        log.info("[websocket消息]连接断开,总数:{}",webSocketSet.size());
   }
  @OnMessage
    public void onMessage(String message){
       log.info("[websocket消息]收到客户端发来的消息:{}",message);
   }
   //使用广播的形式发送消息
    public void sendMessage(String messge){
      for(WebSocket webSocket:webSocketSet){
          log.info("[websocket消息]广播消息,message={}",messge);
          try {
              webSocket.session.getBasicRemote().sendText(messge);
          }catch (Exception e){
              e.printStackTrace();
          }
      }
    }
}
