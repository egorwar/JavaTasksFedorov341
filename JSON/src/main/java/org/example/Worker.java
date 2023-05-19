package org.example;

import java.time.LocalDate;

public class Worker {
    private String name;
    private String midName;
    private String lastName;
    private LocalDate hired;
    private LocalDate fired;

    public Worker(){}
    public Worker(String name, String midName, String lastName, LocalDate hired){
        this.name = name;
        this.midName = midName;
        this.lastName = lastName;
        this.hired = hired;
    }

    public Worker(String name, String midName, String lastName, LocalDate hired, LocalDate fired){
        this(name, midName, lastName, hired);
        this.fired = fired;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMidName(){
        return this.midName;
    }

    public void setMidName(String midName){
        this.midName = midName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public LocalDate getHired(){
        return this.hired;
    }

    public void setHired(LocalDate hired){
        this.hired = hired;
    }

    public LocalDate getFired(){
        return this.fired;
    }

    public void setFired(LocalDate fired){
        this.fired = fired;
    }
}

