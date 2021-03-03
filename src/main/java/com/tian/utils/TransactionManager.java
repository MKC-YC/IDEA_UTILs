package com.tian.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class TransactionManager {
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object transactionAround(ProceedingJoinPoint pjp) {
//定义返回值
//        Object rtValue = null;
//        try {
////获取方法执行所需的参数
//            Object[] args = pjp.getArgs();
////前置通知：开启事务
//            beginTransaction();
////执行方法
//            rtValue = pjp.proceed(args);
////后置通知：提交事务
//            commit();
//        } catch (Throwable e) {
////异常通知：回滚事务
//            rollback();
//            e.printStackTrace();
//        } finally {
////最终通知：释放资源
//            release();
//        }
//        return rtValue;
        return null;
    }
}