
package controlleur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import modele.*;

public class Factory {
private static Connection conn=null;
    private static Statement stm;
    private static PreparedStatement pstmet=null;
    private static ResultSet rs=null;
    
    public static void insererChambre(Chambre c){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion.chambre(id_chamb,numero,capacite,prix,type_chambre) values(?,?,?,?,?)");
            pstmet.setInt(1,c.getIdchamb());
            pstmet.setInt(2,c.getNumero_cha());
            pstmet.setInt(3,c.getCapacite());
            pstmet.setInt(4,c.getPrix_nuit());
            pstmet.setString(5,c.getType_chambre());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererNettoyeur(Nettoyeur m){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion.nettoyeur(id_net,nom,prenom,horaire,tel,id_chambre) values(?,?,?,?,?,?)");
            pstmet.setInt(1,m.getIdnet());
            pstmet.setString(2,m.getNomn());
            pstmet.setString(3,m.getPrenomn());
            pstmet.setString(4,m.getHoraire());
            pstmet.setInt(5,m.getTeleph());
            pstmet.setInt(6,m.getId_cham());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererPatient(Patient t){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion.patient(id_patient,nom,prenom,genre,date,adresse,numerosoc,tel,nationalite) values(?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1,t.getId_pat());
             pstmet.setString(2,t.getNom());
             pstmet.setString(3,t.getPrenom());
            pstmet.setString(4,t.getGenre());
            pstmet.setString(5,t.getDate());
            pstmet.setString(6,t.getAdresse());
            pstmet.setString(7,t.getNumerosoc());
            pstmet.setInt(8,t.getTelep());
            pstmet.setString(9,t.getNational());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    public static void insererAdmission(Admission r){
        try{
            conn=getConnection();
            pstmet=conn.prepareStatement("insert into gestion.admission(id_adm,date_adm,date_sort,id_pat,id_chambre) values(?,?,?,?,?)");
            pstmet.setInt(1,r.getIdadm());
            pstmet.setString(2,r.getDate_admi());
             pstmet.setString(3,r.getDate_sortie()); 
            pstmet.setInt(4,r.getIdpatien());
            pstmet.setInt(5,r.getId_chambre());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }
    
    
    public static ArrayList<Chambre> getchambre(){
        ArrayList<Chambre> lic=new ArrayList();
        Chambre c=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.chambre");
            while(rs.next()){
                c=new Chambre();
                c.setIdchamb(rs.getInt("id_chamb"));
                c.setNumero_cha(rs.getInt("numero"));
                c.setCapacite(rs.getInt("capacite"));
                c.setPrix_nuit(rs.getInt("prix"));
                c.setType_chambre(rs.getString("type_chambre"));
                lic.add(c);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
                                       // la fonction qu'on appel dans le formulaire
    public static ArrayList<Nettoyeur> getnettoyeur(){
        ArrayList<Nettoyeur> lic=new ArrayList();
        Nettoyeur m=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.nettoyeur");
            while(rs.next()){
                m=new Nettoyeur();
                m.setIdnet(rs.getInt("id_net"));
                m.setNomn(rs.getString("nom"));
                m.setPrenomn(rs.getString("prenom"));
                m.setHoraire(rs.getString("horaire"));
                m.setTeleph(rs.getInt("tel"));
                m.setId_cham(rs.getInt("id_chambre"));
                lic.add(m);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
   public static ArrayList<Patient> getpatient(){
        ArrayList<Patient> lic=new ArrayList();
        Patient t=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.patient");
            while(rs.next()){
                t=new Patient();
                t.setId_pat(rs.getInt("id_patient"));
                t.setNom(rs.getString("nom"));
                t.setPrenom(rs.getString("prenom"));
                t.setGenre(rs.getString("genre"));
                t.setDate(rs.getString("date"));
                t.setAdresse(rs.getString("adresse"));
                t.setNumerosoc(rs.getString("numerosoc"));
                t.setTelep(rs.getInt("tel"));
                t.setNational(rs.getString("nationalite"));
                lic.add(t);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    }
    
    public static ArrayList<Admission> getadmission(){
        ArrayList<Admission> lic=new ArrayList();
        Admission r=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.admission");
            while(rs.next()){
                r=new Admission();
                r.setIdadm(rs.getInt("id_adm")); // les infos doivent correspondre de la base de donnees
               r.setDate_admi(rs.getString("date_adm"));
                r.setDate_sortie(rs.getString("date_sort"));
                 r.setIdpatien(rs.getInt("id_pat"));
                 r.setId_chambre(rs.getInt("id_chambre"));
                lic.add(r);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }return lic;
    } 
    
    public static Chambre getChambreID(int ci){  // pour le bouton recherche
        Chambre cli=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.chambre where id_chamb='"+ci+"'");
            if(rs.next()){
                cli=new Chambre();
                cli.setIdchamb(rs.getInt("id_chamb"));
                cli.setNumero_cha(rs.getInt("numero"));
                cli.setCapacite(rs.getInt("capacite"));
                cli.setPrix_nuit(rs.getInt("prix"));
                cli.setType_chambre(rs.getString("type_chambre"));
                
               /* cli.setId(rs.getInt("id_client"));
                cli.setNom(rs.getString("nom"));
                cli.setPrenom(rs.getString("prenom"));
                cli.setAdresse(rs.getString("adresse"));
                cli.setTel(rs.getInt("tel"));
                cli.setNationalite(rs.getString("nationalite")); */
            }
            conn.close();
            stm.close();
            return cli;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Nettoyeur getnettoyeurID(int ci){ // pour le recherche d'un materiel
        Nettoyeur mat=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.nettoyeur where id_net='"+ci+"'");
            if(rs.next()){
                mat=new Nettoyeur();
                mat.setIdnet(rs.getInt("id_net"));
                mat.setNomn(rs.getString("nom"));
                mat.setPrenomn(rs.getString("prenom"));
                mat.setHoraire(rs.getString("horaire"));
                mat.setTeleph(rs.getInt("tel"));
                mat.setId_cham(rs.getInt("id_chambre"));
            }
            conn.close();
            stm.close();
            return mat;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Patient getPatientID(int te){ // rechercher patient
        Patient tec=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.patient where id_patient='"+te+"'");
            if(rs.next()){
                tec=new Patient();
                tec.setId_pat(rs.getInt("id_patient"));
                tec.setNom(rs.getString("nom"));
                tec.setPrenom(rs.getString("prenom"));
                tec.setGenre(rs.getString("genre"));
                tec.setDate(rs.getString("date"));
                tec.setAdresse(rs.getString("adresse"));
                tec.setNumerosoc(rs.getString("numerosoc"));
                tec.setTelep(rs.getInt("tel"));
                tec.setNational(rs.getString("nationalite"));
                
            }
            conn.close();
            stm.close();
            return tec;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    
    public static Admission getAdmissionID(int te){
        Admission rep=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            rs=stm.executeQuery("select * from gestion.admission where id_adm='"+te+"'");
            if(rs.next()){
                rep=new Admission();
                rep.setIdadm(rs.getInt("id_adm"));
                rep.setDate_admi(rs.getString("date_adm"));
                rep.setDate_sortie(rs.getString("date_sort"));
                rep.setIdpatien(rs.getInt("id_pat"));
                rep.setId_chambre(rs.getInt("id_chambre"));
               // rep.setPanne(rs.getString("panne"));
               // rep.setCout(rs.getFloat("cout"));
            }
            conn.close();
            stm.close();
            return rep;
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return null;
        }
    }
    public static void DeleteChambre(Chambre n){ // pour la suppression d'une chambre
        Chambre cli=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion.chambre where id_chamb='"+n.getIdchamb()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteNettoyeur(Nettoyeur n){ // auppression d'un nettoyeur 
        Nettoyeur mat=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re="delete from gestion.nettoyeur where id_net ='"+n.getIdnet()+"'";
            stm.executeUpdate(re);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeletePatient(Patient t){ // suppression d'un patient
        Patient tec=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion.patient where id_patient='"+t.getId_pat()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }
    
    public static void DeleteAdmission(Admission r){
        Admission rep=null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from gestion.admission where id_adm='"+r.getIdadm()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    } 
    // les modification d'un client donc le mise en jour
    public static void ModifyChambreID(int idchamb,int numero_cha, int capacite, int prix_nuit, String type_chambre){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion.chambre set numero='"+numero_cha+"',capacite='"+capacite+"',prix='"+prix_nuit+"',type_chambre='"+type_chambre+"' where id_chamb='"+idchamb+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
                                        // on fait le parametre de tout ceux qu'on peut modifier
    public static void ModifyNettoyeurID(int idnet, int idch, String nomne, String prenom, String horaire, int tel){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion.nettoyeur set nom='"+nomne+"',prenom='"+prenom+"',horaire='"+horaire+"',	id_chambre='"+idch+"' where id_net='"+idnet+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    } 
    
    public static void ModifyPatientID(int id_pat, int telep, String nom,String prenom, String genre, String date,String adresse, String numerosoc, String national){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion.patient set nom='"+nom+"',prenom='"+prenom+"',genre='"+genre+"',date='"+date+"',adresse='"+adresse+"',numerosoc='"+numerosoc+"',tel='"+telep+"',nationalite='"+national+"' where id_patient='"+id_pat+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    } 
    
    public static void ModifyAdmissionID(int idad, String date_ad, String date_so, int idpat, int idch){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update gestion.admission set date_adm='"+date_ad+"',date_sort='"+date_so+"',id_pat='"+idpat+"',id_chambre='"+idch+"' where id_adm='"+idad+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
    }
    
    
    public static Connection getConnection(){
        String serveur="localhost";
        int port=3306;
        String database="gestion";
        String username="root";
        String password="";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://"+serveur+":"+port+"/"+database;
            conn=DriverManager.getConnection(url,username,password);
            System.out.println("connected");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

   

}

