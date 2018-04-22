package chason.learning.ioc.context;

import chason.learning.ioc.beans.ApplicationContext;
import chason.learning.ioc.beans.ClassPathXmlApplicationContext;
import chason.learning.ioc.service.HelloWorldService;
import org.junit.Test;

public class ClassPathXmlApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}