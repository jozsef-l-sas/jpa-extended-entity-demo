package com.jozsef.erb.controller;

import com.jozsef.erb.dto.AccountDTO;
import com.jozsef.erb.dto.SavingsAccountDTO;
import com.jozsef.erb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAllAccounts() {
        List<AccountDTO> accounts = this.accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<AccountDTO> findByName(@PathVariable String name) {
        AccountDTO account = this.accountService.findByName(name);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO account) {
        AccountDTO createdAccount = this.accountService.createAccount(account);
        if (createdAccount != null) {
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/savings")
    public ResponseEntity<List<SavingsAccountDTO>> findAllSavingsAccounts() {
        return new ResponseEntity<>(this.accountService.findAllSavingAccounts(), HttpStatus.OK);
    }

    @PostMapping("/savings")
    public ResponseEntity<SavingsAccountDTO> createAccount(@Valid @RequestBody SavingsAccountDTO account) {
        SavingsAccountDTO createdAccount = this.accountService.createSavingsAccount(account);
        if (createdAccount != null) {
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
