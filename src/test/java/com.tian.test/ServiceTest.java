package com.tian.test;

import com.tian.domain.Apartment;
import com.tian.service.ApartmentService;
import com.tian.service.DormService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        ApartmentService as = (ApartmentService) ac.getBean("apartmentService");
        DormService ds = (DormService) ac.getBean("dormService");
        System.out.println(ds);
        System.out.println(as);
        System.out.println(as.findAll());
        // 调用方法
        List<Apartment> all = as.findAll();
        System.out.println(all);
    }
}
