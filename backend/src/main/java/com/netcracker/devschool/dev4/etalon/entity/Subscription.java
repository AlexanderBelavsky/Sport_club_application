package com.netcracker.devschool.dev4.etalon.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    private int idSubscription;
    private String description;
    private int value;
    private int idGym;
    private String Day1;
    private String Day2;
    private String Month;

    public int getidSubscription() {
        return idSubscription;
    }

    public void setidSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdGym() {
        return idGym;
    }

    public void setIdGym(int idGym) {
        this.idGym = idGym;
    }

    public String getDay1() {
        return Day1;
    }

    public void setDay1(String day1) {
        Day1 = day1;
    }

    public String getDay2() {
        return Day2;
    }

    public void setDay2(String day2) {
        Day2 = day2;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }
}
