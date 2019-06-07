package com.melardev.spring.error_handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class AppJmsErrorHandler implements ErrorHandler {
    private static Logger log = LoggerFactory.getLogger(AppJmsErrorHandler.class);

    @Override
    public void handleError(Throwable throwable) {
        log.error("Error Handler triggered with:" + throwable.getMessage());
    }
}
