package com.jozsef.erb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccountDataDTO {

    private UUID id;
    private BigDecimal financialGoal;
    private Date dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
