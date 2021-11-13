package Managers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterPropertyManager {

    private StringProperty namePropety = new SimpleStringProperty();

    private BooleanProperty nameBoolean = new SimpleBooleanProperty();

    private StringProperty surnameProperty = new SimpleStringProperty();

    private BooleanProperty surnameBoolean = new SimpleBooleanProperty();

    private StringProperty loginProperty = new SimpleStringProperty();

    private BooleanProperty loginBoolean = new SimpleBooleanProperty();

    private StringProperty passwordProperty = new SimpleStringProperty();

    private BooleanProperty passwordBoolean = new SimpleBooleanProperty();

    private StringProperty emailProperty = new SimpleStringProperty();

    private BooleanProperty emailBoolean = new SimpleBooleanProperty();


    public RegisterPropertyManager() {

    }

    public String getNamePropety() {
        return namePropety.get();
    }

    public StringProperty namePropetyProperty() {
        return namePropety;
    }

    public void setNamePropety(String namePropety) {
        this.namePropety.set(namePropety);
    }

    public boolean isNameBoolean() {
        return nameBoolean.get();
    }

    public BooleanProperty nameBooleanProperty() {
        return nameBoolean;
    }

    public void setNameBoolean(boolean nameBoolean) {
        this.nameBoolean.set(nameBoolean);
    }

    public String getSurnameProperty() {
        return surnameProperty.get();
    }

    public StringProperty surnamePropertyProperty() {
        return surnameProperty;
    }

    public void setSurnameProperty(String surnameProperty) {
        this.surnameProperty.set(surnameProperty);
    }

    public boolean isSurnameBoolean() {
        return surnameBoolean.get();
    }

    public BooleanProperty surnameBooleanProperty() {
        return surnameBoolean;
    }

    public void setSurnameBoolean(boolean surnameBoolean) {
        this.surnameBoolean.set(surnameBoolean);
    }

    public String getLoginProperty() {
        return loginProperty.get();
    }

    public StringProperty loginPropertyProperty() {
        return loginProperty;
    }

    public void setLoginProperty(String loginProperty) {
        this.loginProperty.set(loginProperty);
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

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public StringProperty passwordPropertyProperty() {
        return passwordProperty;
    }

    public void setPasswordProperty(String passwordProperty) {
        this.passwordProperty.set(passwordProperty);
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

    public String getEmailProperty() {
        return emailProperty.get();
    }

    public StringProperty emailPropertyProperty() {
        return emailProperty;
    }

    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    public boolean isEmailBoolean() {
        return emailBoolean.get();
    }

    public BooleanProperty emailBooleanProperty() {
        return emailBoolean;
    }

    public void setEmailBoolean(boolean emailBoolean) {
        this.emailBoolean.set(emailBoolean);
    }
}
