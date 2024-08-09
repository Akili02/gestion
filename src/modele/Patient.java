
package modele;


public class Patient {
    private int id_pat, telep;
    private String nom,prenom,genre,date,adresse, numerosoc,national;

    public void setId_pat(int id_pat) {
        this.id_pat = id_pat;
    }

    public void setTelep(int telep) {
        this.telep = telep;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumerosoc(String numerosoc) {
        this.numerosoc = numerosoc;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public int getId_pat() {
        return id_pat;
    }

    public int getTelep() {
        return telep;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNumerosoc() {
        return numerosoc;
    }

    public String getNational() {
        return national;
    }
    public String getIDpat(){
        return id_pat+"-"+nom+"-"+prenom;
    }

    public Patient(int id_pat, int telep, String nom, String prenom, String genre, String date, String adresse, String numerosoc, String national) {
        this.id_pat = id_pat;
        this.telep = telep;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.date = date;
        this.adresse = adresse;
        this.numerosoc = numerosoc;
        this.national = national;
    }
    public Patient(){
        
    }
}
