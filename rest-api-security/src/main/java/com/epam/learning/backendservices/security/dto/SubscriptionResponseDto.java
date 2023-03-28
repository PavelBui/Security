package com.epam.learning.backendservices.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionResponseDto {

    private Long id;

    private Long personId;

    private String startDate;

}
