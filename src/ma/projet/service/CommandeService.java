/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande o) {
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
    public Commande getById(int id) {
        Session session = null;
        Commande e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Commande) session.get(Commande.class, id);
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
    public List<Commande> getAll() {
        Session session = null;
        List<Commande> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Commande").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return produits;
    }

    public void prodByCommande(Commande c) {
        LigneCommandeService ls = new LigneCommandeService();
        System.out.println("Commande: " + c.getId() + "                           Date: " + c.getDate());
        //System.out.println("Réference                 Prix                    Quantité "); 
        System.out.printf("%-25s %-30s %-10s\n", "Réference", "Prix", "Quantité");
        for (LigneCommandeProduit e : ls.getAll()) {
            if (e.getId().getCommande() == c.getId()) {
               // System.out.println(e.getProduit().getReference()+ "                        "+e.getProduit().getPrix()+"                       "+e.getQuantité());
             System.out.printf("%-25s %-30f %-10d\n", 
                         e.getProduit().getReference(),e.getProduit().getPrix(), 
                          e.getQuantité());
       
            }
        }
    }
}
