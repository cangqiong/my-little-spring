package chason.learning.ioc.beans;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 资源的抽象类
 *
 * @author cang
 * @date 2018-04-22
 */
public class Resource {
    private URL url;

    public Resource(URL url) {
        this.url = url;
    }

    public InputStream getInputStream() throws IOException {
        return url == null ? null : url.openConnection().getInputStream();
    }
}
