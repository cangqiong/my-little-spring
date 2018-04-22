package chason.learning.ioc.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象Bean工厂
 *
 * @author cang
 * @date 2018-04-22
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefine> beanDefineMap = new ConcurrentHashMap<>();

    // 获取Bean对象
    @Override
    public Object getBean(String name) throws Exception {

        BeanDefine beanDefine = beanDefineMap.get(name);
        if (beanDefine == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefine.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefine);
        }
        return bean;
    }

    // 注册Bean定义对象
    public void registerBeanDefinition(String name, BeanDefine beanDefine) {
        beanDefineMap.put(name, beanDefine);
    }

    //创建Bean对象
    protected abstract Object doCreateBean(BeanDefine beanDefine) throws Exception;
}
