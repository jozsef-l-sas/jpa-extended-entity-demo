package com.jozsef.erb.repository;

import com.jozsef.erb.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AccountRepository  extends CrudRepository<Account, UUID> {

    Account findByName(String name);

}
