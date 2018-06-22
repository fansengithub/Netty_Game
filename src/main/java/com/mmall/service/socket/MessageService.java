package com.mmall.service.socket;


import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("m")
public class MessageService {



    public Map<String,Object> sendMessage(final ChannelHandlerContext ctx,String id,String message){
        try{
            Map<String,Object> result = new HashMap<String, Object>();


            /**
             * 具体操作
             */

            log.info("id"+id);
            log.info("message"+message);


            result.put("success","1");
            result.put("message","");
            return result;
        }catch (Exception e){
            Map<String,Object> err = new HashMap<String, Object>();
            err.put("success","0");
            err.put("message","系统异常");
            return err;
        }
    }
}
