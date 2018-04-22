package chason.learning.ioc.beans;

/**
 * @author cang
 * @date 2018-04-22
 */
public class PropertieValue {

    private String key;
    private Object value;

    public PropertieValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
