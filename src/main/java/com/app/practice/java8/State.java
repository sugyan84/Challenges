package com.app.practice.java8;

import java.util.ArrayList;
import java.util.List;


public class State {

    List<String> city;

    public State() {
        this.city = new ArrayList<>();
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(final List<String> city) {
        this.city = city;
    }

    public void addCity(String city){
        this.city.add(city);
    }
}
