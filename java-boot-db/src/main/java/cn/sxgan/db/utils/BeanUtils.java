package cn.sxgan.db.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: Bean工具类
 * @Author: sxgan
 * @Date: 2024-05-18 13:19
 * @Version: 1.0
 **/
@Component
public final class BeanUtils  implements BeanFactoryPostProcessor, ApplicationContextAware {
    /** Spring应用上下文环境 */
    private static ConfigurableListableBeanFactory beanFactory;
    
    private static ApplicationContext applicationContext;
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        BeanUtils.beanFactory = beanFactory;
    }
    
    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws org.springframework.beans.BeansException
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException
    {
        return (T) beanFactory.getBean(name);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    
    }
}
