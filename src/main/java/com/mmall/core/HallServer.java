package com.mmall.core;


import com.mmall.common.ApplicationContextHelper;
import com.mmall.core.matchgame.MatchGame;
import com.mmall.netty.socket.EchoServer;
import com.mmall.service.socket.PayService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


@Slf4j
public class HallServer implements ServletContextListener {
    public static PayService payService;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        EchoServer.destory();
        //WebSocketServer.destory();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        payService = ApplicationContextHelper.popBean(PayService.class);
        EchoServer.run();
        //WebSocketServer.run();

        //运行匹配游戏关键代码
//        MatchGame.run();
    }
}
