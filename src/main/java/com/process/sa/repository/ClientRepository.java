package com.process.sa.repository;

import com.process.sa.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* <Client, Integer>:
* Client: c'est pour préciser l'entité qui va etre manipuler, ici c'est la table Client
* Integer: type de donné de la clé primaire, ici c'est un integer
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
