package com.sinaCompany;

import java.util.Scanner;

public class Student {
    Scanner in =new Scanner(System.in);
    private int id;
    private String name;
    private int year;
    private int average;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Student() {
        System.out.println("id :");
        this.id = Integer.parseInt(in.nextLine());
        System.out.println("name :");
        this.name = in.nextLine();
        System.out.println("year :");
        this.year = Integer.parseInt(in.nextLine());
        System.out.println("average :");
        this.average = Integer.parseInt(in.nextLine());
    }
}
