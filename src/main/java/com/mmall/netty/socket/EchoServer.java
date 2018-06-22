package com.mmall.netty.socket;


import io.netty.channel.*;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class EchoServer {

    private static final int PORT = 8866;
    private static ChannelFuture f;

    private static final int READ_IDEL_TIME_OUT = 15; // 读超时
    private static final int WRITE_IDEL_TIME_OUT = 30;// 写超时
    private static final int ALL_IDEL_TIME_OUT = 45; // 所有超时

    //netty 线程池
    private static EventLoopGroup bossGroup;
    private static EventLoopGroup workerGroup;

    public static void run() {

        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        try {
            // (1)服务器辅助启动类配置
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup) //(2) 加入线程组
                    .channel(NioServerSocketChannel.class)  // 设置非阻塞,用它来建立新accept的连接,用于构造serversocketchannel的工厂类
                    .handler(new LoggingHandler(LogLevel.INFO))  //(3) log 支持
                    .childHandler(new ChildChannelHandler())//
                    .option(ChannelOption.SO_BACKLOG, 2048) // (4)设置tcp缓冲区
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); //
            // (5)绑定端口 同步等待绑定成功
            log.info("*********netty 启动成功 端口 "+PORT+" *********");
            f = b.bind(PORT).sync();//(7)
        } catch (Exception e){
            log.info("*********netty 启动失败 端口 "+PORT+" *********");
            log.info(e.getMessage());
            try {
                f.channel().closeFuture().sync();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void destory(){
        log.info("*********EchoServer 销毁 *********");
        try {
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();

    }

    /**
     * 网络事件处理器
     */
    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            // (6)添加自定义协议的编解码工具
            ch.pipeline().addLast(new SmartCarEncoder());  //编码器
            ch.pipeline().addLast(new SmartCarDecoder());  //解码器
            ch.pipeline().addLast(new IdleStateHandler(READ_IDEL_TIME_OUT,
                    WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS)); // 心跳处理
            // 处理网络IO
            ch.pipeline().addLast(new EchoServerHandler());
        }
    }
}
