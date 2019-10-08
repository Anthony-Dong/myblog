package com.blogs.websocket;

import org.eclipse.jetty.websocket.jsr356.decoders.StringDecoder;
import org.eclipse.jetty.websocket.jsr356.encoders.StringEncoder;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName:ChatServerEndPoint
 * Package:com.tyut.websocket.websocketsnapshop.websocket
 * Description:  使用netty时 注意  默认是  jetty竟然只支持GB2312,
 *        decoders：解码器
 *         encoders：编码器
 * @date:2019/7/26 23:26
 * @author: 574986060@qq.com
 */
@Component
@ServerEndpoint(value = "/chat-room/{username}")
public class ChatServerEndPoint {
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<String, Session>();

    private static String name;

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {

        try {
            name = URLDecoder.decode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String sessionId = session.getId();

        livingSessions.put(sessionId, session);

        sendTextAll("欢迎用户[" + name + "] 来到我们的大家庭！");

    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {

//        sendText(session, "用户[" + username + "] : " + message);


        sendTextAll(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"))+" [" + name + "] : " + message);
    }

    private void sendTextAll(String message) {

        livingSessions.forEach((sessionId, session) -> {
            sendText(session,message);
        });
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {

        String sessionId = session.getId();

        //当前的Session 移除
        livingSessions.remove(sessionId);
        //并且通知其他人当前用户已经离开聊天室了
        sendTextAll("用户[" + name + "] 离开了我们的大家庭！");
    }


    private void sendText(Session session, String message) {

        RemoteEndpoint.Basic basic = session.getBasicRemote();

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
