package chason.learning.ioc.service;

import java.util.Date;

/**
 * @author cang
 * @date 2018-04-22
 */
public class OutputService {

    public String getDate() {
        return new Date().toString();
    }
}
