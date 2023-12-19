package com.example.Practice.Fruits.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class FruitServiceInterceptorAppConfig implements WebMvcConfigurer
{
   @Autowired
   FruitServiceInterceptor fruitServiceInterceptor;

   @Override
   public void addInterceptors (InterceptorRegistry registry)
   {
      registry.addInterceptor(fruitServiceInterceptor);
   }
}