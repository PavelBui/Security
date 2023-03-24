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
public class Authority {

    @Id
    @Column(name="authorityId")
    private Long authorityId;

    @Column(name="username")
    private String username;

    @Column(name="authority")
    private String authority;

}
