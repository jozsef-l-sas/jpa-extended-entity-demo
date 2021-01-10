package com.jozsef.erb.dto;

import com.jozsef.erb.entity.AccountType;
import com.neovisionaries.i18n.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCurrencyDTO {

    private UUID id;
    private BigDecimal balance;
    private CurrencyCode currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
