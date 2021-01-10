package com.jozsef.erb.mapper;

import com.jozsef.erb.dto.AccountCurrencyDTO;
import com.jozsef.erb.dto.AccountDTO;
import com.jozsef.erb.entity.Account;
import com.jozsef.erb.entity.AccountCurrency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountCurrencyMapper {

    AccountCurrencyMapper INSTANCE = Mappers.getMapper( AccountCurrencyMapper.class );

    AccountCurrencyDTO entityToDto(AccountCurrency entity);
    AccountCurrency dtoToEntity(AccountCurrencyDTO dto);

}
