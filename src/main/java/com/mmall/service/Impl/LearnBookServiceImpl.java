package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookDetail;
import com.mmall.model.OperaDetail;
import com.mmall.model.OperaDetailExample;
import com.mmall.service.LearnBookService;
import com.mmall.service.OperaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class LearnBookServiceImpl implements LearnBookService{
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;


    /**
     * 教材列表
     * @param param
     * @return
     */
    @Override
    public List<LearnbookDetail> getAllLean(String param) {
        List<LearnbookDetail> learnbookDetails= learnbookDetailMapper.selAllLearnBook(param);
        return learnbookDetails;
    }

    /**
     * 删除
     * @param lid
     * @return
     */
    @Override
    public LayUIResult delLearn(int lid) {
        log.info("lid"+lid);
        LayUIResult layUIResult=new LayUIResult();
        //查询教材下有没有曲谱
        OperaDetailExample example=new OperaDetailExample();
        OperaDetailExample.Criteria criteria= example.createCriteria();
        criteria.andLearnbookIdEqualTo(lid);
        List<OperaDetail> operaDetails=operaDetailMapper.selectByExample(example);
        if(operaDetails.size()>0){
            //有
            layUIResult.setCode(1);
            layUIResult.setMsg("该教材下有曲谱不能删除！");
        }else{
            //删除
            int num=learnbookDetailMapper.deleteByPrimaryKey(lid);
            if(num>0){
                layUIResult.setMsg("删除成功！");
                layUIResult.setCode(0);
            }else{
                layUIResult.setMsg("删除失败！");
                layUIResult.setCode(1);
            }
        }
        return layUIResult;
    }

    @Override
    public LearnbookDetail selLearnbook(int lid) {
        LearnbookDetail learnbookDetail=learnbookDetailMapper.selectByPrimaryKey(lid);
        return learnbookDetail;
    }

    @Override
    public int addLearn(LearnbookDetail learnbookDetail) {
        return  learnbookDetailMapper.insertSelective(learnbookDetail);
    }

    @Override
    public int updateLearn(LearnbookDetail learnbookDetail) {

        return learnbookDetailMapper.updateByPrimaryKeySelective(learnbookDetail);
    }
    @Override
    public LearnbookDetail selectByPrimaryKey(Integer id){
        return learnbookDetailMapper.selectByPrimaryKey(id);
    }
    @Override
    public int updateByPrimaryKeySelective(LearnbookDetail record){
        return learnbookDetailMapper.updateByPrimaryKeySelective(record);
    };

}
