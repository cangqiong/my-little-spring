package chason.learning.ioc.common;

import java.net.URL;

/**
 * 资源加载类
 *
 * @author cang
 * @date 2018-04-22
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new Resource(url);
    }
}
