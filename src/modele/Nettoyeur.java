
package modele;


public class Nettoyeur {
    private int idnet, id_cham,teleph;
    private String nomn, prenomn,horaire;

 

    public void setIdnet(int idnet) {
        this.idnet = idnet;
    }

    public void setId_cham(int id_cham) {
        this.id_cham = id_cham;
    }

    public void setTeleph(int teleph) {
        this.teleph = teleph;
    }

    public void setNomn(String nomn) {
        this.nomn = nomn;
    }

    public void setPrenomn(String prenomn) {
        this.prenomn = prenomn;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public int getIdnet() {
        return idnet;
    }

    public int getId_cham() {
        return id_cham;
    }

    public int getTeleph() {
        return teleph;
    }

    public String getNomn() {
        return nomn;
    }

    public String getPrenomn() {
        return prenomn;
    }

    public String getHoraire() {
        return horaire;
    }

    public Nettoyeur(int idnet, int id_cham, int teleph, String nomn, String prenomn, String horaire) {
        this.idnet = idnet;
        this.id_cham = id_cham;
        this.teleph = teleph;
        this.nomn = nomn;
        this.prenomn = prenomn;
        this.horaire = horaire;
    }
    public Nettoyeur(){
        
    }
}
