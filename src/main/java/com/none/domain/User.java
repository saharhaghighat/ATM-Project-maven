package com.none.domain;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

public class User {
    private Integer Id;
    private String Name;
    private String LastName;
    private Integer age;
    private String NationalCode;
    private LocalDate BirthDay;

    private DateFormat dateFormat=new SimpleDateFormat("EEE, d MMM yyyy");

    public User(String name, String lastName, String nationalCode, LocalDate BirthDay) {
        this.Name = name;
        this.LastName = lastName;
        this.NationalCode = nationalCode;
        this.BirthDay = BirthDay;
        Random random=new Random();
        this.Id= random.nextInt(400);
        this.age= LocalDate.now().getYear()-BirthDay.getYear();
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getNationalCode() {
        return NationalCode;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", NationalCode='" + NationalCode + '\'' +
                ", BirthDay=" + BirthDay +
                "}\n";
    }
}

