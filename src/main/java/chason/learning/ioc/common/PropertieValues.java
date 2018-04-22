package chason.learning.ioc.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cang
 * @date 2018-04-22
 */
public class PropertieValues {
    private List<PropertieValue> propertieValues = new ArrayList<>();

    public void addProperties(PropertieValue propertieValue) {
        for (PropertieValue iter : propertieValues) {
            if (iter.getKey().equals(propertieValue.getKey())) {
                throw new RuntimeException("Properties value is repeat");
            }
        }
        propertieValues.add(propertieValue);
    }

    public List<PropertieValue> getPropertieValues() {
        return propertieValues;
    }

    public void setPropertieValues(List<PropertieValue> propertieValues) {
        this.propertieValues = propertieValues;
    }
}
