package com.epam.learning.backendservices.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto {

    private Long id;

    private String name;

    private String surname;

    private String birthday;

}
