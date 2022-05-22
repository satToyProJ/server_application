package com.example.toy_1st_demo.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/join")
    public AccountDto reqJoin(@RequestBody AccountDto dto) {
        System.out.println("controller 진입 /join");
        System.out.println("id : " + dto.getUsername());
        System.out.println("pw : " + dto.getPassword());
        accountService.createAccount(dto);
        return dto;
    }

    @GetMapping("/user")
    public String authUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("사용자 이름: " + userDetails.getUsername());
        return "user";
    }
}
