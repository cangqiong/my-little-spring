package chason.learning.ioc.common;

import chason.learning.ioc.beans.BeanDefine;
import chason.learning.ioc.beans.BeanDefineReader;
import chason.learning.ioc.beans.BeanReference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 对XML进行Bean配置解析
 *
 * @author cang
 * @date 2018-04-22
 */
public class XmlBeanDefineReader implements BeanDefineReader {

    private ResourceLoader resourceLoader;

    private Map<String, BeanDefine> registry = new HashMap<>();

    public XmlBeanDefineReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void loadBeanDefine(String location) throws Exception {
        InputStream inputStream = resourceLoader.getResource(location).getInputStream();
        doLoadBeanDefine(inputStream);
    }

    private void doLoadBeanDefine(InputStream inputStream) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        parseBeanDefinitions(document.getDocumentElement());
    }


    private void parseBeanDefinitions(Element root) throws ClassNotFoundException {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                BeanDefine beanDefinition = processBeanDefinition(element);
                registry.put(beanDefinition.getId(), beanDefinition);
            }
        }

    }

    private BeanDefine processBeanDefinition(Element element) throws ClassNotFoundException {
        String id = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefine beanDefinition = new BeanDefine(className);
        beanDefinition.setId(id);
        beanDefinition.setType(Class.forName(className));
        processProperty(beanDefinition, element);
        return beanDefinition;
    }

    private void processProperty(BeanDefine beanDefinition, Element ele) {
        NodeList nodeList = ele.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element propertyNode = (Element) node;
                String name = propertyNode.getAttribute("name");
                String value = propertyNode.getAttribute("value");
                if (value != null && value.length() != 0) {
                    beanDefinition.getPropertieValues().addProperties(new PropertieValue(name, value));
                } else {
                    String ref = propertyNode.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new RuntimeException("The configuration problem: the <property> must specify a value or a ref");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertieValues().addProperties(new PropertieValue(name, beanReference));
                }
            }
        }
    }

    public Map<String, BeanDefine> getRegistry() {
        return registry;
    }

}
