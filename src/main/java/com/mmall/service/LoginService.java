package com.mmall.service;


import com.mmall.Object.GameWorld;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service(value="loginService")
public class LoginService {

    public Map<String,Object> login(final ChannelHandlerContext ctx){

        log.info("/******************login****************************/");
        Integer user_id = ctx.channel().attr(GameWorld.userId_key).get();
        if(user_id == null){
            log.info("userId没值" + user_id);
            ctx.channel().attr(GameWorld.userId_key).set(1);
        }else{
            log.info("userId有值" + user_id);
            ctx.channel().attr(GameWorld.userId_key).set(user_id +1);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("hello","netty");
        return  result;

    }
}
