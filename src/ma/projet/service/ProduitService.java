/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.classes.Categorie;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.test.Test;

import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author a
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Produit getById(int id) {
        Session session = null;
        Produit e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return e;
    }

    @Override
    public List<Produit> getAll() {
        Session session = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return produits;
    }

    public void getProdByCat() {
        CategorieService gs = new CategorieService();
        for (Categorie e : gs.getAll()) {
            System.out.println("La catégorie: " + e.getLibelle());
            System.out.println(e.getProduits());
        }
    }

    public void getprodByDate(String d1, String d2) {
        LigneCommandeService ls = new LigneCommandeService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date1 = dateFormat.parse(d1);
            Date date2 = dateFormat.parse(d2);
            System.out.println("Les produits commandés entre " + d1 + " et " + d2 + " :");
            for (LigneCommandeProduit e : ls.getAll()) {
                if (e.getCommande().getDate().before(date1) && e.getCommande().getDate().after(date2)) {
                    System.out.println(e.getProduit());
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void prodprix() {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Produit WHERE prix > 1000";
            List<Produit> produits = new ArrayList<>();
            produits = session.createQuery(hql).list();
            System.out.println("Les produits ayant un prix supérieur à 1000 :");
            for (Produit e : produits) {
                System.out.println(e);
            }
        } catch (Throwable ex) {
            System.err.println("La création de la session a échouée." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
