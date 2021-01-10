package com.jozsef.erb.repository;

import com.jozsef.erb.entity.Account;
import com.jozsef.erb.entity.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, UUID> {

}
