package com.zhouyu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import(WebServiceAutoConfiguration.class )  //springboot-demo包的config类是扫描不到的，所以要导入
// or define it in spring.factories
public class MySpringbootDemoApplication {
}
