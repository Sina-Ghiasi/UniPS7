package com.sinaCompany;

import java.util.Scanner;

public class User {
    Scanner in = new Scanner(System.in);

    private int code;
    private String user;
    private String pass;
    private String email;
    private int age;
    private String studyLevel;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }

    public User() {
        this.code = Integer.parseInt(in.nextLine());
        this.user = in.nextLine();
        this.pass = in.nextLine();
        this.email = in.nextLine();
        this.age = Integer.parseInt(in.nextLine());
        this.studyLevel = in.nextLine();

    }


}
