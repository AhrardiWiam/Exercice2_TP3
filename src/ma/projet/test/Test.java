/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.LignePK;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService ss = new CommandeService();
        LigneCommandeService ls = new LigneCommandeService();
        
        //Créer les catégories
//        cs.create(new Categorie("F14H6","Pc portable"));
//        cs.create(new Categorie("F1J5","Clavier"));
//        cs.create(new Categorie("F34JA","Souris"));
        
        //Créer les produits 
//        ps.create(new Produit("HP", 3479, cs.getById(1)));
//        ps.create(new Produit("DELL", 3259,cs.getById(1)));
//        ps.create(new Produit("DELL", 279,cs.getById(2) ));
//        ps.create(new Produit("HP", 179,cs.getById(2) ));
//        ps.create(new Produit("HP", 139,cs.getById(3)));
        
        //Créer les commandes
//        ss.create(new Commande(new Date()));
//        ss.create(new Commande(new Date()));
        
        
        //Créer les lignes de commandes
//        ls.create(new LigneCommandeProduit(new LignePK(1, 1 ), 3));
//        ls.create(new LigneCommandeProduit(new LignePK(3, 1 ), 5));
//        ls.create(new LigneCommandeProduit(new LignePK(5, 1 ), 2));
//        ls.create(new LigneCommandeProduit(new LignePK(3, 2 ), 9));
//        ls.create(new LigneCommandeProduit(new LignePK(5, 2 ), 6));
//        ls.create(new LigneCommandeProduit(new LignePK(2, 2 ), 1));
        
        //Afficher les produit par Catégorie
        //ps.getProdByCat();
        
        //Afficher les produits commandés entre deux dates
        //ps.getprodByDate("2024/10/14",  "2024/10/12");
        
        //Afficher les produits d'une commande
         //ss.prodByCommande(ss.getById(1));
        
        //Afficher les produits ayant un prix supérieru a 1000 dh
        ps.prodprix();
    }
    
}
