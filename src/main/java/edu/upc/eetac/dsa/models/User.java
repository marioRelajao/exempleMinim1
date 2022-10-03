package edu.upc.eetac.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String userID;

    private String name;

    private String surname;

    private List<Order> orders;     //Array de order

    public User(String userID, String name, String surname) {       //Constructor del User
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.orders = new LinkedList<>();       //Creamos una linked-list vacia
    }
}
