package com.softuni.toolmarket.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class UserRegistrationDTO {
    @NotBlank
    private String userName;
    @NotBlank
    private String identificationNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;

    public UserRegistrationDTO() {
    }

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
