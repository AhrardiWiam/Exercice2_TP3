/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.List;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private LignePK id;
    private int quantité;
    @ManyToOne
    @JoinColumn(name = "produit", insertable = false, updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande", insertable = false, updatable = false)
    private Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(LignePK id, int quantité) {
        this.id = id;
        this.quantité = quantité;
        this.produit = produit;
        this.commande = commande;
    }

    public LigneCommandeProduit(int quantité, Produit produit, Commande commande) {
        this.quantité = quantité;
        this.produit = produit;
        this.commande = commande;
    }

    public LignePK getId() {
        return id;
    }

    public void setId(LignePK id) {
        this.id = id;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "LigneCommandeProduit{ quantit\u00e9=" + quantité + ", produit=" + produit + ", commande=" + commande + '}'+"\n";
    }
    
    
}
