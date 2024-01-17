package com.project.ProjectFlightsSpring;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Controller

public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String helloWorld() {
        System.out.println("sdfsdfdsfsfsdfsdds");
        return "hello world!!!!!!!!!!!!!!!!!!!!!!!!";
    }
    @GetMapping(value = "/hello" )
    public String helloPage() {
        return "welcome";
    }


}
