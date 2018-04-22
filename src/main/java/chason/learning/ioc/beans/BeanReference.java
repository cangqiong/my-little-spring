package chason.learning.ioc.beans;

/**
 * @author cang
 * @date 2018-04-22
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String ref) {
        this.name = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
