package com.epam.learning.backendservices.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class UserAuthority {

    @Id
    private Long id;

    private String username;

    private String authority;

}
