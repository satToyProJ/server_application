package com.example.toy_1st_demo.connect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectController {

    @GetMapping("/demo")
    public Test nameJY() {
        System.out.println("demo 들어옴");
        Test test = new Test();
        test.setName("jun young");
        return test;
    }

    @GetMapping("/demo2")
    public Test nameHJ() {
        System.out.println("demo2 들어옴");
        Test test = new Test();
        test.setName("hyo jin");
        return test;
    }

}
