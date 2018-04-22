package chason.learning.ioc.beans.factory;

import chason.learning.ioc.beans.BeanDefine;
import chason.learning.ioc.common.ResourceLoader;
import chason.learning.ioc.common.XmlBeanDefineReader;
import chason.learning.ioc.context.AbstractApplicationContext;
import chason.learning.ioc.context.AutowireCapableBeanFactory;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefineReader xmlBeanDefinitionReader = new XmlBeanDefineReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefine(configLocation);
        for (Map.Entry<String, BeanDefine> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
