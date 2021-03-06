package com.solverpeng.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class TheController {
    @RequestMapping(value = "/test1")
    public String handle1 (ServletWebRequest swr) {
        return "myView";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public String handle2 (WebRequest swr) {

        String testBody = "<p>Response content: content 2 " +
                "</p><a href='test2'>test2</a>";
        return testBody;
    }

    @ResponseBody
    @RequestMapping(value = "/test3")
    public ResponseEntity<String> handle3 (WebRequest swr) {

        String testBody = "<p>Response content: content 2 " +
                "</p><a href='test2'>test2</a>";
        return ResponseEntity
                .ok()
                .body(testBody);
    }
}
