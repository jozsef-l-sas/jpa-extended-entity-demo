package com.jozsef.erb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="account")
@DiscriminatorValue(AccountType.Values.SAVINGS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccount extends Account {

    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @NotNull
    private SavingsAccountData savingsAccountData;

}
