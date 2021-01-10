package com.jozsef.erb.mapper;

import com.jozsef.erb.dto.SavingsAccountDTO;
import com.jozsef.erb.entity.SavingsAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SavingsAccountMapper {

    SavingsAccountMapper INSTANCE = Mappers.getMapper( SavingsAccountMapper.class );

    SavingsAccountDTO entityToDto(SavingsAccount entity);
    SavingsAccount dtoToEntity(SavingsAccountDTO dto);

}
