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
    public String reqJoin(@RequestBody AccountDto dto) {
        accountService.createAccount(dto);
        return "true";
    }

    @GetMapping("/user")
    public String authUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return "user";
    }
}
