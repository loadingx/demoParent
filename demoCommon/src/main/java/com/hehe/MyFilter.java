package com.hehe;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        filterChain.doFilter(servletRequest, servletResponse);
        HttpServletRequest res = (HttpServletRequest)servletRequest;
        HttpSession session = res.getSession();
        String admin = (String) session.getAttribute("admin");

        ServletContext servletContext = session.getServletContext();
        //使用这个web工具类拿到WebApplicationContext对象
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //能通过WebApplicationContext类拿到已经初始化的Bean
        Around around = (Around) webApplicationContext.getBean("around");
        //通过set方法注入数据
        around.setAdminName(admin);


    }

    public void destroy() {

    }
}
