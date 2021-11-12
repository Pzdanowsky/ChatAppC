package Repositories;

import javafx.beans.property.*;

import java.util.ArrayList;

public class LoginPropertyManager {

   private StringProperty login = new SimpleStringProperty();

   private BooleanProperty loginBoolean = new SimpleBooleanProperty(false);

   private StringProperty password = new SimpleStringProperty();

   private BooleanProperty passwordBoolean = new SimpleBooleanProperty(false);


   public LoginPropertyManager(){
        loginBoolean.bind(login.isEmpty());
   }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public boolean isLoginBoolean() {
        return loginBoolean.get();
    }

    public BooleanProperty loginBooleanProperty() {
        return loginBoolean;
    }

    public void setLoginBoolean(boolean loginBoolean) {
        this.loginBoolean.set(loginBoolean);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public boolean isPasswordBoolean() {
        return passwordBoolean.get();
    }

    public BooleanProperty passwordBooleanProperty() {
        return passwordBoolean;
    }

    public void setPasswordBoolean(boolean passwordBoolean) {
        this.passwordBoolean.set(passwordBoolean);
    }
}
