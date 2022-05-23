package com.example.toy_1st_demo.connect;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"0. connection"})
@RestController
public class ConnectController {

    @ApiOperation(value = "준영님 연결테스트", notes = "")
    @GetMapping("/demo")
    public Test nameJY() {
        System.out.println("demo 들어옴");
        Test test = new Test();
        test.setName("jun young");
        return test;
    }

    @ApiOperation(value = "효진님 연결테스트", notes = "")
    @GetMapping("/demo2")
    public Test nameHJ() {
        System.out.println("demo2 들어옴");
        Test test = new Test();
        test.setName("hyo jin");
        return test;
    }

}
