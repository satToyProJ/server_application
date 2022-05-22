package com.example.toy_1st_demo.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountRepository accountRepository;

    @Transactional
    public void createAccount(AccountDto dto) {
        if (accountRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException ("이미 존재하는 id 입니다.");
        }
        Account account = Account.builder()
                .username(dto.getUsername())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .roles("ROLE_USER")
                .build();
        accountRepository.save(account);
    }
}
