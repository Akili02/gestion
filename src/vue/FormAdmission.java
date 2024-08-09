
package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import vue.*;
import modele.*;
import controlleur.*;

public class FormAdmission extends JFrame implements ActionListener{
     JLabel lid,ldate_ad,ldate_so,lidpat,lidch;
    JComboBox tidpat,tidch;
    //JDate tdate;
    JTextField tid,tdate_ad,tdate_so;
    JButton enr,vis,init,del,rech,upd;
    ArrayList <Admission> listeAdmission= new ArrayList();
    ArrayList <Patient> listePatient= new ArrayList();
    ArrayList <Chambre> listeChambre= new ArrayList();
    JTable tbtechnicien;
   private final DefaultTableModel model;
    Admission re=new Admission();
    Admission rep=null;
    int index=0;
    int ind=0;
    
     public FormAdmission(){
        lid=new JLabel("No");
        lid.setBounds(10,30,100,30);
        this.getContentPane().add(lid);
        
        tid=new JTextField("");
        tid.setBounds(120,30,100,30);
        this.getContentPane().add(tid);
        
        rech=new JButton("Rechercher");
        rech.setBounds(230,30,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        ldate_ad=new JLabel("Date d'admission");
        ldate_ad.setBounds(10,70,100,30);
        this.getContentPane().add(ldate_ad);
        
        tdate_ad=new JTextField("");
        tdate_ad.setBounds(120,70,100,30);
        this.getContentPane().add(tdate_ad);
        
        ldate_so=new JLabel("date de sortie");
        ldate_so.setBounds(10,110,100,30);
        this.getContentPane().add(ldate_so);
        
        tdate_so=new JTextField("");
        tdate_so.setBounds(120,110,100,30);
        this.getContentPane().add(tdate_so);
        
        lidpat=new JLabel("No Patient");
        lidpat.setBounds(10,150,100,30);
        this.getContentPane().add(lidpat);
        
         tidpat=new JComboBox();
        listePatient=Factory.getpatient();
        for(Patient t:listePatient){
            tidpat.addItem(t.getIDpat());
        }
        tidpat.setBounds(120,150,150,30);
        tidpat.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=tidpat.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(tidpat);
        
         lidch=new JLabel("No Chambre");
        lidch.setBounds(10,190,100,30);
        this.getContentPane().add(lidch);
        
        tidch=new JComboBox();
        listeChambre=Factory.getchambre();
        for(Chambre m:listeChambre){
            tidch.addItem(m.getIDChambre());
        }
        tidch.setBounds(120,190,200,30);
        tidch.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            ind=tidch.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(tidch);
         
        enr=new JButton("Enregistrer");
        enr.setBounds(10,300,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("Visualiser");
        vis.setBounds(120,300,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Initialiser");
        init.setBounds(230,300,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Supprimer");
        del.setBounds(340,300,100,30);
       del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Modifier");
        upd.setBounds(450,300,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
        model=new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Date d'Admission");
        model.addColumn("Date de Sortie");
        model.addColumn("Patient");
        model.addColumn("Chambre");
        
        this.setLayout(null);
        
}
   public void effacer(){
        tid.setText("");
        tdate_ad.setText("");
        tdate_so.setText("");
    }
    public void recupInfo(Admission r){
        //tnum.setText(cr.getNum());
         tid.setText(String.valueOf(r.getIdadm()));
        tdate_ad.setText(String.valueOf(r.getDate_admi()));
        tdate_so.setText(String.valueOf(r.getDate_sortie()));
        String etr=getPatient(r.getIdpatien());
        tidpat.setSelectedItem(etr);
        String ert=getChambre(r.getId_chambre()); // lorsqu'on cherche que ca nous affiche meme les son combobox de la cle etrangere
        tidch.setSelectedItem(ert);
       
    }
   public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeAdmission= Factory.getadmission();
        for(Admission r:listeAdmission){
            model.addRow(new Object[]{
                    r.getIdadm(),r.getDate_admi(),r.getDate_sortie(),r.getIdpatien(),r.getId_chambre()}
            );
        }
         
        tbtechnicien=new JTable(model);
    JScrollPane p=new JScrollPane(tbtechnicien);
    p.setBounds(60,500,300,100);
    this.getContentPane().add(p);
    }
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==enr){
           int m=Integer.valueOf(tid.getText());
           String dte=tdate_ad.getText();
           String dt=tdate_so.getText();
            int tec=listePatient.get(index).getId_pat(); // de la  classe patient pour le c getter
            int mat=listeChambre.get(ind).getIdchamb();
            re=new Admission(m,tec,mat,dte,dt);
            Factory.insererAdmission(re);
        }
       else if(e.getSource()==vis){
            afficher();
        }
        else if(e.getSource()==init){
            effacer();
        } else if(e.getSource()==del){
            if(rep !=null){ String msg="Voulez-vous reelement supprimer la reparation du technicien n°"+rep.getIdadm()+" de la liste des reparations";
                int re=JOptionPane.showConfirmDialog(null,msg);
                if(re==0){
                    Factory.DeleteAdmission(rep);
                    afficher();
                    effacer();
                }
            }
        } else if(e.getSource()==rech){
            int ct=Integer.valueOf(tid.getText());
            //String ct=tdate.getText();
            rep=Factory.getAdmissionID(ct); //on fait appel a un membre d'une instance ici donc classe Factory.membre
            if(rep!=null){
                recupInfo(rep);
            }
        
   } 
       else if(e.getSource()==upd){
            int idd=Integer.valueOf(tid.getText());
            String prn=tdate_ad.getText();
            String pan=tdate_so.getText();
            int cli=listePatient.get(index).getId_pat(); // selon la classe patient donc tout 
            int mat=listeChambre.get(index).getIdchamb();
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controlleur.Factory.ModifyAdmissionID(idd,prn,pan,cli,mat);
                afficher();
            }
        }
   }
   String getPatient(int num){
        String nume="";
        for(Patient te:listePatient){
            if(te.getId_pat()==num){
                nume=te.getIDpat();
                break;
            }
        }return nume;
    }
    
    String getChambre(int num){ // pour que la recherche amene meme le combobox de la cle etrangere
        String nume="";
        for(Chambre ma:listeChambre){
            if(ma.getIdchamb()==num){
                nume=ma.getIDChambre(); // celle definie en combobox
                break;
            }
        }return nume;
    
}
}