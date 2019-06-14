package com.example.mvvmsample;

/**
 * Created by Administrator on 2019/6/10 0010.
 *
 * @author Administrator
 */
public class User {
    public final String firstName;
    public final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}