package by.zakharenko.cafe.entity;

import by.zakharenko.cafe.entity.enumeration.UserRole;

public class UserAccount extends CafeEntity {
    private final long id;
    private String login;
    private String password;
    private UserRole role;
    private boolean status;

    public UserAccount(long id, String login, String password, UserRole role, boolean status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public UserAccount(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean isStatus() {
        return status;
    }
}
