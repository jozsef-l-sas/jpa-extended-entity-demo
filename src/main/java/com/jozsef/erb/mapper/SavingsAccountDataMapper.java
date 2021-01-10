package com.jozsef.erb.mapper;

import com.jozsef.erb.dto.SavingsAccountDataDTO;
import com.jozsef.erb.entity.SavingsAccountData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SavingsAccountDataMapper {

    SavingsAccountDataMapper INSTANCE = Mappers.getMapper( SavingsAccountDataMapper.class );

    SavingsAccountDataDTO entityToDto(SavingsAccountData entity);
    SavingsAccountData dtoToEntity(SavingsAccountDataDTO dto);

}
