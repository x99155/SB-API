# API RESTfull avec Spring Boot et Java

Dans le cadre de mon apprentissage du Framework Spring Boot, j'ai développé cette API qui permet à un utilisateur 
de donner son avis.

## Table des matières

- [Prérequis](#prérequis)
- [Technologies utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Configuration de la base de données](#configuration-de-la-base-de-données)
- [Lancement de l'application](#lancement-de-lapplication)
- [Fonctionnalités couvertes](#fonctionnalités-couvertes)
- [Structure du projet](#structure-du-projet)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Prérequis

Avant de commencer, assure-toi d'avoir installé les outils suivants :

- Java 17 ou supérieur
- Maven 4.0+
- Docker
- IntelliJ IDEA

## Technologies utilisées

Ce projet utilise les technologies et frameworks suivants :

- **Spring Boot** : Framework principal pour le développement de l'application
- **Spring Data JPA** : Pour interagir avec la base de données
- **MariaDB** : Base de données relationnelle utilisée via Docker
- **Docker** : Pour containeriser la base de données MariaDB
- **REST API** : Pour exposer les services de l'application

## Installation

1. Clone le dépôt du projet sur ta machine locale :
    ```bash
    git clone https://github.com/x99155/SB-API
    cd SB-API
    ```

2. Compile le projet avec Maven :
    ```bash
    mvn clean install
    ```

## Configuration de la base de données

Le projet utilise MariaDB comme base de données. Un fichier `docker-compose.yml` est fourni pour faciliter la configuration.

1. Assure-toi que Docker est installé et en cours d'exécution sur ta machine.
2. Démarre MariaDB via Docker en utilisant `docker-compose` :
    ```bash
    docker-compose up -d
    ```

3. Les paramètres de connexion à la base de données sont définis dans le fichier `application.properties` :
    ```properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/nom_de_ta_bdd
    spring.datasource.username=utilisateur
    spring.datasource.password=mot_de_passe
    ```

Assure-toi d'adapter ces informations en fonction de ta configuration.

## Lancement de l'application

Une fois la base de données configurée et Docker en cours d'exécution, tu peux lancer l'application Spring Boot :

```bash
mvn spring-boot:run
