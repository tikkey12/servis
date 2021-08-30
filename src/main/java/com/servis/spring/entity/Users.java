package com.servis.spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    public Users() {

    }

    public Users(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    //public String restoreKey = "";
    //public boolean getIsChangePasswordMode() {
        //return !this.restoreKey.equals("");
    //}
}
