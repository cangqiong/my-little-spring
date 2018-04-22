package chason.learning.ioc.context;

import chason.learning.ioc.beans.factory.AbstractBeanFactory;

/**
 * 抽象上下文对象
 *
 * @author cang
 * @date 2018-04-22
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    // 容器初始化
    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
