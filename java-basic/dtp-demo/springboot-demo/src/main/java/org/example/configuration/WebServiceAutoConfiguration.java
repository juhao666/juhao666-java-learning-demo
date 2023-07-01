package org.example.configuration;

import org.example.annotations.ConditionalOnClass;
import org.example.conditions.TomcatCondition;
import org.example.services.impl.JettyWebServiceImpl;
import org.example.services.impl.TomcatWebServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class WebServiceAutoConfiguration {

    @Bean
    //@Conditional(TomcatCondition.class)  //optional 1
    @ConditionalOnClass("org.eclipse.jetty.server.server") // optional 2
    public JettyWebServiceImpl getJettry(){
        return new JettyWebServiceImpl();
    }

    @Bean
    public TomcatWebServiceImpl getTomcat(){
        return new TomcatWebServiceImpl();
    }
}
