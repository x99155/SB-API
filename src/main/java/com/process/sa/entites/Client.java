package com.process.sa.entites;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private Date creation;
    private Date modification;

    // Constructeur sans argument
    public Client() {
    }

    // Constructeur avec tous les argguments
    public Client(int id, String email, Date creation, Date modification) {
        this.email = email;
        this.id = id;
        this.creation = creation;
        this.modification = modification;
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

    public Date getCreation() {
        return creation;
    }
    public void setCreation(Date creation) {
        this.creation = creation;
    }
    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }

    // This method is called before the entity is persisted
    @PrePersist
    protected void onCreate() {
        creation = new Date();
        modification = new Date();
    }

    // This method is called before the entity is updated
    @PreUpdate
    protected void onUpdate() {
        modification = new Date();
    }
}
