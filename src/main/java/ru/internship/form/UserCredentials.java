package ru.internship.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCredentials {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16)
    private String login;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
