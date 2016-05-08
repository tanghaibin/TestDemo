package top.tanghaibin.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/2/17.
 */
public class Log4jDemo {

    private static final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);

    public static void main(String[]args){

        logger.debug("debug...");
        logger.error("error...");
        logger.warn("warn...");
        logger.info("info...");
    }
}
