# Exercice2_TP3 : Application de Gestion des Produits d'un Magasin


## Outils Utilisés
- **Java 8** (IDE : NetBeans)
- **Hibernate** (pour la persistance des données)
- **MySQL** (pour la gestion de la base de données)

## Structure du Projet
Le projet est organisé en plusieurs packages avec les classes et interfaces suivantes :

![image](https://github.com/user-attachments/assets/835b616e-065c-49be-9ec2-8d47b4ccd3b8)

### A. Couche Persistance
- **ma.projet.classes** :Contient les classes entités représentant les tables de la base de données, telles que :
    - `Produit`
    - `Categorie`
    - `Commande`
    - `LigneCommande`

- **ma.projet.config**
  - `hibernate.cfg.xml` : Fichier de configuration Hibernate pour se connecter à la base de données.

- **ma.projet.util**
  - `HibernateUtil` : Classe utilitaire permettant de créer et gérer l'instance de la `SessionFactory` pour les sessions Hibernate.

### B. Couche Service
- **ma.projet.dao**
  - `IDao` : Interface générique définissant les méthodes CRUD pour les entités.

- **ma.projet.service**
  - `ProduitService` : Classe implémentant les opérations de gestion des produits.
  - `CategorieService` : Classe implémentant les opérations de gestion des catégories.
  - `CommandeService` : Classe implémentant les opérations de gestion des commandes.
  - `LigneCommandeService` : Classe implémentant les opérations de gestion des lignes de commande.

## Fonctionnalités de l'Application
L'application permet d'effectuer les opérations suivantes :

1. **Afficher la liste des produits par catégorie** .
2. **Afficher la liste des produits commandés entre deux dates**.
3. **Afficher les produits commandés dans une commande donnée**, avec les informations détaillées comme la référence, le prix, et la quantité des produits.
4. **Afficher la liste des produits dont le prix est supérieur à 1000 DH**.

## Vue relationnelle entre les différentes entités au niveau de la Base de donné
![exo2](https://github.com/user-attachments/assets/532cfa4f-ecac-445c-a70e-686010235f54)



## Démonstration


https://github.com/user-attachments/assets/e63a6504-3d97-44c2-9e65-37edd3388e23


