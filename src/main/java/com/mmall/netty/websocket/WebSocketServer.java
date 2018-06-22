package com.mmall.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WebSocketServer {


    public static boolean iswss = false ;   //是否启用wss   启用时 需配置SslUtils 证书

    private final static int PORT = 9999;
    private static Channel ch;

    private static final int READ_IDEL_TIME_OUT = 15; // 读超时
    private static final int WRITE_IDEL_TIME_OUT = 30;// 写超时
    private static final int ALL_IDEL_TIME_OUT = 45; // 所有超时


    //netty 线程池
    private static EventLoopGroup bossGroup;
    private static EventLoopGroup workerGroup;

    public static void run(){

        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

        try{
            // (1)服务器辅助启动类配置
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup) //(2) 加入线程组
                    .channel(NioServerSocketChannel.class) // 设置非阻塞,用它来建立新accept的连接,用于构造serversocketchannel的工厂类
                    .handler(new LoggingHandler(LogLevel.INFO))  //(3) log 支持
                    .childHandler(new ChildChannelWebSocketHandler())//
                    .option(ChannelOption.SO_BACKLOG, 1024) // (4)设置tcp缓冲区
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // (5)绑定端口 同步等待绑定成功
            log.info("*********netty 启动成功 端口 "+PORT+" *********");
            ch =  b.bind(PORT).sync().channel();
        }catch (Exception e){
            log.info("*********netty WEBSocket启动失败 端口 "+PORT+" *********");
            log.info(e.getMessage());
            try {
                ch.closeFuture().sync();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void destory() {
        log.info("*********WebSocketServer 销毁 *********");
        try {
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();

    }


    /**
     * 网络事件处理器
     */
    private static class ChildChannelWebSocketHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {


            // wss
            if(iswss){
                SSLContext sslContext = SslUtil.createSSLContext(); ///SslUtil自定义类 WSS 支持
                SSLEngine sslEngine = sslContext.createSSLEngine();
                sslEngine.setUseClientMode(false); /// 是否使用客户端模式
                sslEngine.setNeedClientAuth(false); //// 是否需要验证客户端
                ch.pipeline().addLast(new SslHandler(sslEngine));
            }


            ch.pipeline().addLast(new HttpServerCodec()); // HttpServerCodec：将请求和应答消息解码为HTTP消息
            ch.pipeline().addLast(new WebSocketEncoder());  //自定义编码器
            ch.pipeline().addLast(new HttpObjectAggregator(65536)); // HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
            ch.pipeline().addLast(new ChunkedWriteHandler()); // ChunkedWriteHandler：向客户端发送HTML5文件  WEbSOCKET 支持
            ch.pipeline().addLast(new IdleStateHandler(READ_IDEL_TIME_OUT,
                    WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS)); // 心跳处理

            // 处理网络IO
            ch.pipeline().addLast(new EchoWebSocketServerHandler());  //WEbSOCKET Handler
        }
    }
}
