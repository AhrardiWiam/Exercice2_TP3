/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class LignePK implements Serializable{
    private int produit;
    private int commande;

    public LignePK() {
    }

    public LignePK(int produit, int commande) {
        this.produit = produit;
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }
    
}
