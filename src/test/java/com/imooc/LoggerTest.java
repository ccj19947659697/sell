package com.imooc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by home on 2019/2/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Slf4j//不用引入当前类
//@Data
public class LoggerTest {
    //private final Logger logger = LoggerFactory.getLogger(LoggerTest2.class);
   private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);//为了每次不写当前类名加注解Slf4j
    @Test
    public void test1(){
        String name ="imooc";
        String password="123456";
        logger.debug("debug....");
        logger.info("name:"+ name + ", password:"+password);//日志输出变量
        logger.info("name:{}, password:{}",name,password);
        logger.error("error.ftl");
        logger.warn("warn");

    }


}
