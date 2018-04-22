package chason.learning.ioc.beans;

import chason.learning.ioc.common.PropertieValues;

/**
 * Bean 定义
 *
 * @author cang
 * @date 2018-04-22
 */
public class BeanDefine {
    private String id;
    private Class<?> type;
    private String className;
    private Object bean;
    private PropertieValues propertieValues = new PropertieValues();

    public BeanDefine(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public PropertieValues getPropertieValues() {
        return propertieValues;
    }

    public void setPropertieValues(PropertieValues propertieValues) {
        this.propertieValues = propertieValues;
    }
}
