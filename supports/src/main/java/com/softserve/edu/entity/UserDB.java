package com.softserve.edu.entity;

public class UserDB {
	public static final String GET_USER_BY_LOGIN = "SELECT ID, FirstName, LastName, Login, Password, Email, RoleRef FROM dbo.Users WHERE Login = '%s';";
    public static final String GET_ALL_USERS = "SELECT ID, FirstName, LastName, Login, Password, Email, RoleRef FROM dbo.Users;";
	public static final String DELETE_USER_BY_ID = "DELETE dbo.Users WHERE ID='%s';";
    //
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private Long role;

    public UserDB(Long id, String firstName, String lastName, String login,
            String password, String email, Long role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "id= " + id.toString() + " " + "firstName= " + firstName + " "
                + "lastName= " + lastName + " " + "login= " + login + " "
                + "password= " + password + " " + "email= " + email + " "
                + "role= " + role.toString();
    }
}
