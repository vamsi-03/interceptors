package com.example.Practice.Fruits.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FruitServiceInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("In the preHandle() method: Before sending request to controller.");
        return true;
    }

    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("In the postHandle() method: Before sending response to client.");
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
        System.out.println("In the afterCompletion() method: After sending response to client.");
    }
}