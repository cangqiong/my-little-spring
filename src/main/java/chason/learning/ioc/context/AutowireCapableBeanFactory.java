package chason.learning.ioc.context;


import chason.learning.ioc.beans.factory.AbstractBeanFactory;
import chason.learning.ioc.beans.BeanDefine;
import chason.learning.ioc.beans.BeanReference;
import chason.learning.ioc.common.PropertieValue;

import java.lang.reflect.Field;


public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefine beanDefine) throws Exception {
        Object bean = createBeanInstance(beanDefine);
        beanDefine.setBean(bean);
        applyPropertyValues(bean, beanDefine);
        return bean;
    }

    protected Object createBeanInstance(BeanDefine beanDefine) throws Exception {
        return beanDefine.getType().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefine mbd) throws Exception {
        for (PropertieValue propertyValue : mbd.getPropertieValues().getPropertieValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getKey());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            declaredField.set(bean, value);
        }
    }

}
