package com.mmall.netty.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;


@Slf4j
public class SslUtil {

    private static volatile SSLContext sslContext = null;

    private static String type = "JKS";

    private static String path = "/home/java/test.tangrangame.com/Tomcat/test.tangrangame.com.jks";

    private static String password = "Jiuying2018";

    public static SSLContext createSSLContext() throws Exception {
        try{
            if(null == sslContext){
                synchronized (SslUtil.class) {
                    if(null == sslContext){
                        KeyStore ks = KeyStore.getInstance(type); /// "JKS"  　　　　  　　
                        InputStream ksInputStream = new FileInputStream(path); /// 证书存放地址
                        ks.load(ksInputStream, password.toCharArray());
                        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                        kmf.init(ks, password.toCharArray());
                        sslContext = SSLContext.getInstance("TLS");
                        sslContext.init(kmf.getKeyManagers(), null, null);
                    }
                }
            }
            return sslContext;
        }catch (Exception e){
            log.info(e.getMessage());
            return null;
        }

    }

}
