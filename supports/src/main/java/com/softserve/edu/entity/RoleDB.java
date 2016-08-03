package com.softserve.edu.entity;

public class RoleDB {
    public static final String GET_ROLE_BY_ID = "SELECT ID, RoleName FROM dbo.Roles WHERE ID = '%s';";
    public static final String GET_ALL_ROLES = "SELECT ID, RoleName FROM dbo.Roles;";
    //
    private Long id;
    private String roleName;

    public RoleDB(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
