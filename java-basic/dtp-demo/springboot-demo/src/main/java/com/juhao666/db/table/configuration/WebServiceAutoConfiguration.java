package com.juhao666.db.table.configuration;

import com.juhao666.db.table.annotations.ConditionalOnClass;
import com.juhao666.db.table.services.impl.JettyWebServiceImpl;
import com.juhao666.db.table.services.impl.TomcatWebServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceAutoConfiguration {

    @Bean
    //@Conditional(TomcatCondition.class)  //optional 1
    @ConditionalOnClass("org.eclipse.jetty.server.server") // optional 2
    public JettyWebServiceImpl getJetty(){
        return new JettyWebServiceImpl();
    }

    @Bean
    public TomcatWebServiceImpl getTomcat(){
        return new TomcatWebServiceImpl();
    }
}
