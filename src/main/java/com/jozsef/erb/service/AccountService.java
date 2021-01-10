package com.jozsef.erb.service;

import com.jozsef.erb.dto.AccountDTO;
import com.jozsef.erb.dto.SavingsAccountDTO;
import com.jozsef.erb.entity.Account;
import com.jozsef.erb.entity.SavingsAccount;
import com.jozsef.erb.mapper.AccountCurrencyMapper;
import com.jozsef.erb.mapper.AccountMapper;
import com.jozsef.erb.mapper.SavingsAccountDataMapper;
import com.jozsef.erb.mapper.SavingsAccountMapper;
import com.jozsef.erb.repository.AccountRepository;
import com.jozsef.erb.repository.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    public List<AccountDTO> findAllAccounts() {
        List<Account> accountEntities = (List<Account>) this.accountRepository.findAll();
        List<AccountDTO> accounts = accountEntities.stream().map(entity -> AccountMapper.INSTANCE.entityToDto(entity)).collect(Collectors.toList());
        return accounts;
    }

    public AccountDTO findByName(String name) {
        Account accountEntity = this.accountRepository.findByName(name);
        AccountDTO account = null;
        if (accountEntity != null) {
            account = AccountMapper.INSTANCE.entityToDto(accountEntity);
        }
        return account;
    }

    public AccountDTO createAccount(AccountDTO accountDto) {
        Account account = AccountMapper.INSTANCE.dtoToEntity(accountDto);
        if (accountDto.getAccountData() != null) {
            account.setAccountCurrency(AccountCurrencyMapper.INSTANCE.dtoToEntity(accountDto.getAccountData()));
        }
        Account savedAccountEntity = this.accountRepository.save(account);
        AccountDTO savedAccount = null;
        if (savedAccountEntity != null) {
            savedAccount = AccountMapper.INSTANCE.entityToDto(savedAccountEntity);
        }
        return savedAccount;
    }

    public List<SavingsAccountDTO> findAllSavingAccounts() {
        List<SavingsAccount> accountEntities = (List<SavingsAccount>) this.savingsAccountRepository.findAll();
        List<SavingsAccountDTO> accounts = accountEntities.stream().map(entity -> SavingsAccountMapper.INSTANCE.entityToDto(entity)).collect(Collectors.toList());

        return accounts;
    }

    public SavingsAccountDTO createSavingsAccount(SavingsAccountDTO accountDto) {
        SavingsAccount account = SavingsAccountMapper.INSTANCE.dtoToEntity(accountDto);
        if (accountDto.getAccountData() != null) {
            account.setAccountCurrency(AccountCurrencyMapper.INSTANCE.dtoToEntity(accountDto.getAccountData()));
        }
        if (accountDto.getSavingsAccountData() != null) {
            account.setSavingsAccountData(SavingsAccountDataMapper.INSTANCE.dtoToEntity(accountDto.getSavingsAccountData()));
        }
        SavingsAccount savedAccountEntity = this.savingsAccountRepository.save(account);
        SavingsAccountDTO savedAccount = SavingsAccountMapper.INSTANCE.entityToDto(savedAccountEntity);

        return savedAccount;
    }

}
