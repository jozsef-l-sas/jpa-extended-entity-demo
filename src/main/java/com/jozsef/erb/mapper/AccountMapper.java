package com.jozsef.erb.mapper;

import com.jozsef.erb.dto.AccountDTO;
import com.jozsef.erb.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="name", source="entity.name"),
            @Mapping(target="type", source="entity.type"),
            @Mapping(target="currency", source="entity.currency"),
            @Mapping(target="createdAt", source="entity.createdAt"),
            @Mapping(target="updatedAt", source="entity.updatedAt"),
            @Mapping(target="accountData", source="entity.accountCurrency")
    })
    AccountDTO entityToDto(Account entity);

    @Mappings({
            @Mapping(target="id", source="dto.id"),
            @Mapping(target="name", source="dto.name"),
            @Mapping(target="type", source="dto.type"),
            @Mapping(target="currency", source="dto.currency"),
            @Mapping(target="createdAt", source="dto.createdAt"),
            @Mapping(target="updatedAt", source="dto.updatedAt"),
            @Mapping(target="accountCurrency", source="dto.accountData")
    })
    Account dtoToEntity(AccountDTO dto);

}
