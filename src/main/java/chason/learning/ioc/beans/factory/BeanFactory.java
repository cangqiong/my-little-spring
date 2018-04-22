package chason.learning.ioc.beans.factory;

/**
 * 抽象Bean工厂
 *
 * @author cang
 * @date 2018-04-22
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
