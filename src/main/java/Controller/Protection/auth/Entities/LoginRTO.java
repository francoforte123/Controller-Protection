package Controller.Protection.auth.Entities;

import Controller.Protection.Entities.User;

public class LoginRTO {

    private User user;
    private String jwt;

    public LoginRTO(User user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public LoginRTO() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
