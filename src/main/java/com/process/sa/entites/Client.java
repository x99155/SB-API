package com.process.sa.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    // Attributs de ma table clients
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;

    // Constructeur sans argument
    public Client() {
    }

    // Constructeur avec tous les argguments
    public Client(String email, int id) {
        this.email = email;
        this.id = id;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
