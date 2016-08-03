package com.softserve.edu.data;

public class User implements ILogin, IPassword, IName, IEmail, IRole, IBuild {
    private String login;
    private String password;
    private String name;
    private String email;
    private String role;

    private User() {
    }

    public static ILogin get() {
        return new User();
    }

    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IName setPassword(String password) {
        this.password = password;
        return this;
    }

    public IEmail setName(String name) {
        this.name = name;
        return this;
    }

    public IRole setEmail(String email) {
        this.email = email;
        return this;
    }

    public IBuild setRole(String role) {
        this.role = role;
        return this;
    }

    public User build() {
        return this;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRole() {
        return this.role;
    }
}
