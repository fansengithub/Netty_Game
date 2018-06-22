package com.mmall.service.socket;

import com.mmall.Object.GameWorld;
import com.mmall.dao.ElecPlayerMapper;
import com.mmall.dao.RechargePackageMapper;
import com.mmall.dao.SkinDetailMapper;
import com.mmall.entity.AimSkinDetail;
import com.mmall.model.ElecPlayer;
import com.mmall.model.RechargePackage;
import com.mmall.model.SkinDetail;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("s")
public class ShoppingMall {
    @Autowired
    private SkinDetailMapper skinDetailMapper;

    @Autowired
    private ElecPlayerMapper elecPlayerMapper;

    @Autowired
    private RechargePackageMapper rechargePackageMapper;

    /**
     * 商城初始化
     * @param ctx
     * @return
     */
    public Map<String,Object> shopInit(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        try {
//            skinDetailMapper
            //            获取当前登录用户id
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            List<SkinDetail> skinDetailList= skinDetailMapper.getAllSkinDetail("","","");
            List<AimSkinDetail>  aimSkinDetailList = new ArrayList<>();

            skinDetailList.forEach((SkinDetail  skinDetail) ->{
                AimSkinDetail aimSkinDetail = new AimSkinDetail();
                aimSkinDetail.setItemID(skinDetail.getId()+"");
                aimSkinDetail.setItemName(skinDetail.getName());
                aimSkinDetail.setItemImg(skinDetail.getSkinPicture());
                aimSkinDetail.setItemPawPrice(skinDetail.getPrice1()+"");
                aimSkinDetail.setItemScorePrice(skinDetail.getPrice2()+"");
                aimSkinDetail.setIsHave(0+"");
                if (skinDetail.getPriceChoice() ==1){
                    aimSkinDetail.setCurrentType(0+"");
                }else {
                    aimSkinDetail.setCurrentType(2+"");
                }

                aimSkinDetailList.add(aimSkinDetail);
            });

            map.put("socre",elecPlayer.getScore());
            map.put("paws",elecPlayer.getXiongzhang());
            map.put("success", 1);
            map.put("message", "操作成功!");
            map.put("goodsItem",aimSkinDetailList);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败!");
        }
        return map;
    }


    public Map<String,Object> rechargeInit(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        try {

            List<RechargePackage> rechargePackageList = rechargePackageMapper.selectAll();

            map.put("success", 1);
            map.put("message", "操作成功!");
            map.put("rechangeItem",rechargePackageList);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败!");
        }
        return map;
    }



}
