package com.softuni.toolmarket.model.dto;

import org.springframework.lang.NonNull;

public class UserRegistrationDTO {
@NonNull
    private String userName;
    @NonNull
    private String identificationNumber;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String confirmPassword;

    public String getUserName() {
        return userName;
    }

    public UserRegistrationDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public UserRegistrationDTO setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "userName='" + userName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
