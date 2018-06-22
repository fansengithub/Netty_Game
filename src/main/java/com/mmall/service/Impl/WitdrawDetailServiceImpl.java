package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.WitdrawDetailMapper;
import com.mmall.model.WitdrawDetail;
import com.mmall.service.WitdrawDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WitdrawDetailServiceImpl implements WitdrawDetailService {
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private WitdrawDetailMapper witdrawDetailMapper;
    /**
     * 提现详情列表
     * @param param
     * @return
     */
    @Override
    public List<WitdrawDetail> getAllWitdrawDetail(String param,String stage,String startTime,String endTime) {
        log.info("体现条件");
//        Date newStart=null;
//        Date newend=null;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        if (startTime!=null&&!"".equals(startTime)){
//            newStart=dateFormat.parse(startTime);
//            log.info("时间"+newStart);
//        }
//        if (startTime!=null&&!"".equals(endTime)){
//            newend=dateFormat.parse(endTime);
//        }
        List<WitdrawDetail> WitdrawDetailList= witdrawDetailMapper.selAllWitdrawDetail(param,stage,startTime,endTime);
        log.info("返回个数="+WitdrawDetailList.size());
        return WitdrawDetailList;
    }
    @Override
    public List<WitdrawDetail> getAllWitdrawDetailByService(Integer uid,String param,String stage,String startTime,String endTime) {
        log.info("体现条件");
        List<WitdrawDetail> WitdrawDetailList= witdrawDetailMapper.selAllWitdrawDetailByService(uid,param,stage,startTime,endTime);
        log.info("返回个数="+WitdrawDetailList.size());
        return WitdrawDetailList;
    }
    @Override
    public List<WitdrawDetail> getAllWitdrawDetailByOrganization(Integer uid,String param,String stage,String startTime,String endTime) {
        log.info("体现条件");
        List<WitdrawDetail> WitdrawDetailList= witdrawDetailMapper.selAllWitdrawDetailByOrganization(uid,param,stage,startTime,endTime);
        log.info("返回个数="+WitdrawDetailList.size());
        return WitdrawDetailList;
    }
    @Override
    public List<WitdrawDetail> getAllWitdrawDetailByPianoShop(Integer uid,String param,String stage,String startTime,String endTime) {
        log.info("体现条件");
        List<WitdrawDetail> WitdrawDetailList= witdrawDetailMapper.selAllWitdrawDetailByPianoShop(uid,param,stage,startTime,endTime);
        log.info("返回个数="+WitdrawDetailList.size());
        return WitdrawDetailList;
    }
    @Override
    public int updateByPrimaryKeySelective(WitdrawDetail record){
        return witdrawDetailMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int insert(WitdrawDetail record){
        return  witdrawDetailMapper.insert(record);
    };

}
