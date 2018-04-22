package chason.learning.ioc.beans;

/**
 * 抽象Bean文件读取类
 *
 * @author cang
 * @date 2018-04-22
 */
public interface BeanDefineReader {
    void loadBeanDefine(String location) throws Exception;
}
