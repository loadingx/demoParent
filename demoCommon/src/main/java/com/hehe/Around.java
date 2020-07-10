package com.hehe;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
public class Around implements MethodInterceptor {

    /**
     * 在过滤器中获取到session名字 获取到当前bean注入adminName
     */
    private String adminName;

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {


        //修改之后就是不在这里面获取adminname
        Date date = new Date();
        //什么事情
        Method method = mi.getMethod();
        //拿到类对象  反射
        LogAnno annotation = method.getAnnotation(LogAnno.class);
        //通过反射拿到的实例  调用方法
        String name = annotation.value();
        //是否成功
        boolean flag = false;
        Object proceed = null;
        try {
            proceed = mi.proceed();
            flag=true;
        }catch (Exception a){
            a.printStackTrace();
        }
        System.out.println(adminName+"管理员在"+date+"执行了"+name+"成功了么？"+flag);

        return mi.proceed();
    }

    /*public Object invoke(MethodInvocation mi) throws Throwable {
        *//*
         * 1.什么人--------
         * 2.什么时间 new Date()
         * 3.什么事情----方法名
         * 4.是否成功-----能
         * 解决办法利用spring di特性
         * *//*
        ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取HttpRequst对象，于Servlet强耦合
        HttpSession session = s.getRequest().getSession();
        //拿到存放在Session的数据
        String adminName = (String)session.getAttribute("admin");
        //时间
        Date date = new Date();
        //什么事情
        Method method = mi.getMethod();
        //拿到类对象  反射
        LogAnno annotation = method.getAnnotation(LogAnno.class);
        //通过反射拿到的实例  调用方法
        String name = annotation.value();
        //是否成功
        boolean flag = false;
        Object proceed = null;
        try {
            proceed = mi.proceed();
            flag=true;
        }catch (Exception a){
            a.printStackTrace();
        }
        //这里不做插入数据库的操作
        System.out.println(adminName+"管理员在"+date+"执行了"+name+"成功了么？"+flag);
        return proceed;*/
    }

