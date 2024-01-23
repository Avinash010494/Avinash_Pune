package com.mahindrafinance.assignment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UserDetails")
public class User {

    @Id
    @Column(name = "Id",nullable = false,unique = true)
    String userId;
    @Column(name = "Name")
    String userName;
    @Column(name = "Email")
    String userEmail;
    @Column(name = "Password")
    String userPassword;

}
