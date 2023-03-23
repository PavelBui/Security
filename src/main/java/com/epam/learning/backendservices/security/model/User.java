package com.epam.learning.backendservices.security.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name="username")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="failedLogin")
    private int failedLogin;

    @Column(name="enabled")
    private boolean enabled;

    public User() {};

    public User(String username, String password, String email, int failedLogin, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.failedLogin = failedLogin;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFailedLogin() {
        return failedLogin;
    }

    public void setFailedLogin(int failedLogin) {
        this.failedLogin = failedLogin;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
