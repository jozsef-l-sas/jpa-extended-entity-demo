package com.jozsef.erb.service;

import com.jozsef.erb.entity.Account;
import com.jozsef.erb.entity.SavingsAccount;
import com.jozsef.erb.repository.AccountRepository;
import com.jozsef.erb.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    public List<Account> findAllAccounts() {
        List<Account> accounts = (List<Account>) this.accountRepository.findAll();
        return accounts;
    }

    public Account findByName(String name) {
        Account account = this.accountRepository.findByName(name);
        return account;
    }

    public Account createAccount(Account account) {
        Account savedAccount = this.accountRepository.save(account);
        return savedAccount;
    }

    public List<SavingsAccount> findAllSavingAccounts() {
        List<SavingsAccount> accounts = (List<SavingsAccount>) this.savingsAccountRepository.findAll();
        return accounts;
    }

    public SavingsAccount createSavingsAccount(SavingsAccount account) {
        SavingsAccount savedAccount = this.savingsAccountRepository.save(account);
        return savedAccount;
    }

}
