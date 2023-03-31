package com.softuni.toolmarket.model.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String identificationNumber;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "userName")
    private List<ToolEntity> toolsList;
    @OneToMany(mappedBy = "client")
    private List<OrdersEntity> orders;

    public UserEntity() {
    }

    public List<ToolEntity> getToolsList() {
        return toolsList;
    }

    public UserEntity setToolsList(List<ToolEntity> toolsList) {
        this.toolsList = toolsList;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public UserEntity setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    //адване на роля
    public UserEntity addRole(UserRoleEntity role) {
        this.roles.add(role);
        return this;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public UserEntity setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : "[N/A]") + '\'' +
                ", roles=" + roles +
                ", toolsList=" + toolsList +
                ", orders=" + orders +
                '}';
    }
}