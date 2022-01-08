package com.sirenk.core.user.config;

import com.sirenk.core.common.http.intercepter.CommonHttpRequestInterceptor;
import com.sirenk.core.user.interfaces.user.session.UserSessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final CommonHttpRequestInterceptor commonHttpRequestInterceptor;
    private final UserSessionInterceptor userSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonHttpRequestInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(userSessionInterceptor)
                .addPathPatterns("/**");
    }

}
