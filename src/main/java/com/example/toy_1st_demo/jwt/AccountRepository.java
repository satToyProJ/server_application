package com.example.toy_1st_demo.jwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
    boolean existsByUsername(String username);
}
