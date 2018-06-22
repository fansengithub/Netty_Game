package com.mmall.Test;

import com.mmall.dao.ElecPlayerMapper;
import com.mmall.dao.ParentsMapper;
import com.mmall.dao.StudentsMapper;
import com.mmall.dto.ScoreTopNum;
import com.mmall.model.ElecPlayer;
import com.mmall.util.AgeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Slf4j
public class MyTest {
    @Autowired
    private ParentsMapper parentsMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private ElecPlayerMapper elecPlayerMapper;
    @Test
    public void test1(){
        List<ElecPlayer> players=parentsMapper.selParentsAndstus(2);
        log.info(""+players.get(0).getName());
    }
    @Test
    public void test2(){
        int num=AgeUtil.getAgeFromBirthTime("1997-10-07");
        log.info(""+num);
    }

    @Test
    public void test3(){
        List<ElecPlayer> elecPlayers=elecPlayerMapper.getStuByPid(1);
        log.info(elecPlayers+"");
    }


    @Test
    public void test4(){
        boolean b=isInteger("我");
        log.info(""+b);
    }
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    @Test
    public void test5(){
        String [] str={"1"};
        log.info(str.length+"");
    }

    @Test
    public void test6(){
        List<ScoreTopNum> scoreTopNums=elecPlayerMapper.getScoreTopNum(100);
        for (ScoreTopNum scoreTopNum : scoreTopNums) {
            log.info(scoreTopNum+"");
        }
    }
}
