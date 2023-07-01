package org.dtp;

import org.dtp.utils.DtpUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * auther: 图灵课堂-大都督周瑜
 */

public class DtpBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DtpExecutor) {
            DtpUtil.put(beanName, (DtpExecutor) bean);
        }

        return bean;
    }
}
