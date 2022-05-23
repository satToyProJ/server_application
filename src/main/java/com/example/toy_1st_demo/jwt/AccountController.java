package com.example.toy_1st_demo.jwt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. auth"})
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ApiOperation(value = "회원가입")
    @PostMapping("/join")
    public AccountDto reqJoin(@RequestBody AccountDto dto) {
        System.out.println("controller 진입 /join");
        System.out.println("id : " + dto.getUsername());
        System.out.println("pw : " + dto.getPassword());
        accountService.createAccount(dto);
        return dto;
    }

    @ApiOperation(value = "사용자 권한", notes = "로그인중일때만 접근이 가능한 페이지")
    @GetMapping("/user")
    public String authUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("사용자 이름: " + userDetails.getUsername());
        return "user";
    }
}
