package com.oauth2.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.oauth2.server")
public class WebConfig  implements WebMvcConfigurer{
	

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(freemarkerViewResolver());
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
        
        registry
        .addResourceHandler("/static/**")
        .addResourceLocations("classpath:/static/");
    }

	@Bean 
	public FreeMarkerViewResolver freemarkerViewResolver() { 
	    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver(); 
	    resolver.setCache(true); 
	    resolver.setPrefix(""); 
	    resolver.setSuffix(".ftl"); 
	    return resolver; 
	}
	

}
