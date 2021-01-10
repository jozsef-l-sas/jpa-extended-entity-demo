package com.jozsef.erb.controller;

import com.jozsef.erb.entity.Account;
import com.jozsef.erb.entity.SavingsAccount;
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
    public ResponseEntity<List<Account>> findAllAccounts() {
        return new ResponseEntity<>(this.accountService.findAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Account> findByName(@PathVariable String name) {
        Account account = this.accountService.findByName(name);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        if (account.getAccountCurrency() != null) {
            account.getAccountCurrency().setAccount(account);
        }
        Account createdAccount = this.accountService.createAccount(account);
        if (createdAccount != null) {
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/savings")
    public ResponseEntity<List<SavingsAccount>> findAllSavingsAccounts() {
        return new ResponseEntity<>(this.accountService.findAllSavingAccounts(), HttpStatus.OK);
    }

    @PostMapping("/savings")
    public ResponseEntity<SavingsAccount> createAccount(@Valid @RequestBody SavingsAccount account) {
        if (account.getAccountCurrency() != null) {
            account.getAccountCurrency().setAccount(account);
        }
        if (account.getSavingsAccountData() != null) {
            account.getSavingsAccountData().setAccount(account);
        }
        SavingsAccount createdAccount = this.accountService.createSavingsAccount(account);
        if (createdAccount != null) {
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
