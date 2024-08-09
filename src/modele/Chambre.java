
package modele;


public class Chambre {
    private int idchamb, numero_cha,capacite,prix_nuit;
    private String type_chambre;

    public void setIdchamb(int idchamb) {
        this.idchamb = idchamb;
    }

    public void setNumero_cha(int numero_cha) {
        this.numero_cha = numero_cha;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setPrix_nuit(int prix_nuit) {
        this.prix_nuit = prix_nuit;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public int getIdchamb() {
        return idchamb;
    }

    public int getNumero_cha() {
        return numero_cha;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getPrix_nuit() {
        return prix_nuit;
    }

    public String getType_chambre() {
        return type_chambre;
    }
     public String getIDChambre(){
        return idchamb+"-"+type_chambre+"-"+prix_nuit;
        }


    public Chambre(int idchamb, int numero_cha, int capacite, int prix_nuit, String type_chambre) {
        this.idchamb = idchamb;
        this.numero_cha = numero_cha;
        this.capacite = capacite;
        this.prix_nuit = prix_nuit;
        this.type_chambre = type_chambre;
    }
    public Chambre(){
        
    }
        }
    

