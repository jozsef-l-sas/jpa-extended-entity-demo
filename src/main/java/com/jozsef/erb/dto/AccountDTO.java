package com.jozsef.erb.dto;

import com.jozsef.erb.entity.AccountCurrency;
import com.jozsef.erb.entity.AccountType;
import com.neovisionaries.i18n.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private UUID id;
    private String name;
    private AccountType type;
    private CurrencyCode currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private AccountCurrencyDTO accountData;

}
