package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * Created by home on 2019/2/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j//不用引入当前类
//@Data
public class LoggerTest2 {
    @Test
    public void test1(){
        String name ="imooc";
        String password="123456";
        log.debug("debug....");
        log.info("name:"+ name + ", password:"+password);//日志输出变量
        log.info("name:{}, password:{}",name,password);
        log.error("error.ftl");
        log.warn("warn");
    }
}
