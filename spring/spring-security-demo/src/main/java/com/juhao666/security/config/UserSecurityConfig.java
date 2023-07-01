package com.juhao666.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/unauthn.html");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/demo/hello").permitAll();
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login") //登录访问路径
                //.defaultSuccessUrl("/demo/index")//登录成功后跳转路径
                .defaultSuccessUrl("/success.html")//登录成功后跳转路径
                .permitAll()
                .and().authorizeRequests()
                .antMatchers("/","/demo/hello","/user/login").permitAll() //设置那些访问路径不要认证
                //只有admin才可以访问/demo/index
                //.antMatchers("/demo/index").hasAuthority("admin")
                //.antMatchers("/demo/index").hasAnyAuthority("admin","manager")
                .antMatchers("/demo/index").hasRole("admin")
                .anyRequest().authenticated()
                .and().csrf().disable();//close csrf防护


    }
}
