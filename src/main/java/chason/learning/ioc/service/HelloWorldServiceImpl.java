package chason.learning.ioc.service;

/**
 * @author cang
 * @date 2018-04-22
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private String text;
    private String age;
    private OutputService outputService;

    @Override
    public void helloWorld() {
        System.out.println("{text='" + text + '\'' +
                ", age=" + age +
                ", outputService=" + outputService.getDate() +
                '}');
    }

}
