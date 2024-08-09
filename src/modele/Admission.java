
package modele;

public class Admission {
    private int idadm, idpatien, id_chambre;
    private String date_admi, date_sortie;

    public void setIdadm(int idadm) {
        this.idadm = idadm;
    }

    public void setIdpatien(int idpatien) {
        this.idpatien = idpatien;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public void setDate_admi(String date_admi) {
        this.date_admi = date_admi;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public int getIdadm() {
        return idadm;
    }

    public int getIdpatien() {
        return idpatien;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public String getDate_admi() {
        return date_admi;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public Admission(int idadm, int idpatien, int id_chambre, String date_admi, String date_sortie) {
        this.idadm = idadm;
        this.idpatien = idpatien;
        this.id_chambre = id_chambre;
        this.date_admi = date_admi;
        this.date_sortie = date_sortie;
    }
      public Admission(){
          
      }
}
