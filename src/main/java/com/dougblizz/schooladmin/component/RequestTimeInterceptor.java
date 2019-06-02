package com.dougblizz.schooladmin.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
    public static final Log LOG= LogFactory.getLog(RequestTimeInterceptor.class);

    //Primero
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starTime",System.currentTimeMillis());
        return true;
    }
    //Segundo
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long starTime= (long) request.getAttribute("starTime");
        LOG.info("--REQUEST URL: '"+ request.getRequestURL().toString()+"' -- TOTAL TIME: '"+ (System.currentTimeMillis()-starTime)+"'ms");
    }
}
