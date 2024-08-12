CREATE DATABASE sa;

USE sa;

-- Table des clients
CREATE TABLE clients (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(65) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table des avis utilisateurs
CREATE TABLE reviews (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    description VARCHAR(255),
    type VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);


