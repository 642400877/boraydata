package com.boraydata.hygiene.web.config;

import com.boraydata.hygiene.web.Interceptor.ProcessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 这里需要先将限流拦截器入住，不然无法获取到拦截器中的redistemplate
     * @return
     */
    @Bean
    public ProcessInterceptor getAccessLimitIntercept() {
        return new ProcessInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(getAccessLimitIntercept());
        registration.addPathPatterns("/**");                      //所有路径都被拦截
//        registration.excludePathPatterns("/api/private/v1/login");                         //添加不拦截路径
    }

}
