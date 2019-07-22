package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

@Controller
public class MyController {
    private Logger logger = Logger.getLogger(MyController.class.getSimpleName());

    @RequestMapping("test")
    @ResponseBody
    public DeferredResult<String> handleTestRequest () {
        logger.info("handler started");
        final DeferredResult<String> deferredResult = new DeferredResult<>();
        new Thread(() -> {
            logger.info("async task started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("async task finished");
            deferredResult.setResult("test async result");
        }).start();

        logger.info("handler finished");
        return deferredResult;
    }
}
