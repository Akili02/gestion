
package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;

import controlleur.*;
import modele.*;

public class FormPatient extends JFrame implements ActionListener{
    JLabel lid,lnom,lpre,lgn,lnat,ldtemb,ltelephone,lnumeros,lad; 
    JTextField tid,tnom,tpre,tdtemb,ttele, tnumero,tad;
    JComboBox tnat;
    JRadioButton gnm,gnf;
    JButton enr,vis,init,del,rech,upd;
    String gnr=null;
    String[] pays={"Burundi","Rwanda","Tanzanie","RDC","Kenya","Soudan du sud","Ouganda"};
    ArrayList <Patient> listePatient= new ArrayList();
    JTable tbtechnicien;
   private final DefaultTableModel model;
    Patient t=new Patient();
    Patient tchn=null;
    
    public FormPatient(){
        
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
        
        lnom=new JLabel("Nom");
        lnom.setBounds(10,70,100,30);
        this.getContentPane().add(lnom);
        
        tnom=new JTextField("");
        tnom.setBounds(120,70,100,30);
        this.getContentPane().add(tnom);
        
        lpre=new JLabel("Prenom");
        lpre.setBounds(10,110,100,30);
        this.getContentPane().add(lpre);
        
        tpre=new JTextField("");
        tpre.setBounds(120,110,100,30);
        this.getContentPane().add(tpre);
        
        lgn=new JLabel("Genre");
        lgn.setBounds(10,150,100,30);
        this.getContentPane().add(lgn);
        
        gnm=new JRadioButton("M");
        gnm.setBounds(120,150,50,30);
        this.getContentPane().add(gnm);
        
        gnf=new JRadioButton("F");
        gnf.setBounds(180,150,50,30);
        this.getContentPane().add(gnf);
        ButtonGroup g=new ButtonGroup();
        g.add(gnm);
        g.add(gnf);
        
        lnat=new JLabel("Nationalité");
        lnat.setBounds(10,190,100,30);
        this.getContentPane().add(lnat);
        
        tnat=new JComboBox(pays);
        tnat.setBounds(120,190,100,30);
        this.getContentPane().add(tnat);
        
        lad=new JLabel("Adresse");
        lad.setBounds(10,230,100,30);
        this.getContentPane().add(lad);
        
         tad=new JTextField("");
        tad.setBounds(120,230,100,30);
        this.getContentPane().add(tad);
        
        ldtemb=new JLabel("Date de naissance");
        ldtemb.setBounds(10,260,100,30);
        this.getContentPane().add(ldtemb);
        
        tdtemb=new JTextField(10);
        tdtemb.setBounds(120,260,100,30);
        this.getContentPane().add(tdtemb);
        
        ltelephone=new JLabel("Telephone");
        ltelephone.setBounds(10,300,100,30);
        this.getContentPane().add(ltelephone);
        
        ttele=new JTextField("");
        ttele.setBounds(120,300,100,30);
        this.getContentPane().add(ttele);
        
         lnumeros=new JLabel("No Social");
        lnumeros.setBounds(10,340,100,30);
        this.getContentPane().add(lnumeros);
        
        tnumero=new JTextField("");
        tnumero.setBounds(120,340,100,30);
        this.getContentPane().add(tnumero);
        
        enr=new JButton("Enregistrer");
        enr.setBounds(10,400,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("Visualiser");
        vis.setBounds(120,400,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Initialiser");
        init.setBounds(230,400,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Supprimer");
        del.setBounds(340,400,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Modifier");
        upd.setBounds(450,400,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
      model=new DefaultTableModel();
      model.addColumn("No");
       model.addColumn("Nom");
       model.addColumn("Prenom");
        model.addColumn("Genre");
        model.addColumn("Date de Naissance");
         model.addColumn("Adresse");
         model.addColumn("Numero social");
       model.addColumn("Telephone");
      model.addColumn("Nationalite");
        
        this.setLayout(null);
}
     
    public void effacer(){ // cette fonction nous aide  a reinitialiser donc a mettre les case vide
        tid.setText("");
        tnom.setText("");
        tpre.setText("");
        tad.setText("");
        tdtemb.setText("");
        ttele.setText("");
         tnumero.setText("");
         tnat.setSelectedIndex(-1);
        
    }
      public void recupInfo(Patient t){
        //tnum.setText(cr.getNum());
        tid.setText(String.valueOf(t.getId_pat()));
        tnom.setText(String.valueOf(t.getNom()));
        tpre.setText(t.getPrenom());
        if(t.getGenre().equalsIgnoreCase(gnm.getText())) gnm.setSelected(true);else gnf.setSelected(true);
        tnat.setSelectedItem(t.getNational());
        tad.setText(t.getAdresse());
        tdtemb.setText(String.valueOf(t.getDate()));
        ttele.setText(String.valueOf(t.getTelep()));
        tnumero.setText(String.valueOf(t.getNumerosoc()));
        
    }
   
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int m=Integer.valueOf(tid.getText());
            String n=tnom.getText();
            String p=tpre.getText();
            if(gnm.isSelected()){
                gnr="M";
            }else if(gnf.isSelected()){
                gnr="F";
            }
            String d=tdtemb.getText();
            String a=tad.getText();
            String v=tnumero.getText();
            int te = Integer.valueOf(ttele.getText());
            String na=String.valueOf(tnat.getSelectedItem());
            
            //Date dte=formatter.format(d);
           // float s=Float.valueOf(tsal.getText());
            t=new Patient(m,te,n,p,gnr,d,a,v,na);
            Factory.insererPatient(t);
      
        }
     else if(e.getSource()==vis){
            afficher();
        }
     else if(e.getSource()==init){
            effacer();
        }else if(e.getSource()==del){
            if(tchn !=null){
                String msg="Voulez-vous reelement supprimer "+tchn.getId_pat()+" de la liste des techniciens";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeletePatient(tchn);
                    afficher();
                    effacer();
                }
            }
        }
     else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(tid.getText());
            tchn=Factory.getPatientID(ct);
            if(tchn!=null){
                recupInfo(tchn);
            }
        }else if(e.getSource()==upd){ // les boutons modifier avec toutes ses fonctions
            int idd=Integer.valueOf(tid.getText());
            int tp=Integer.valueOf(ttele.getText());
            String nm=tnom.getText();
            String prn=tpre.getText();
            String gnr="";
            if(gnm.isSelected()){
                gnr=gnm.getText();
            }else if(gnf.isSelected()){
                gnr=gnf.getText();
            }
            String dt=tdtemb.getText();
            String ad=tad.getText();
            String tn=tnumero.getText();
            String nat=String.valueOf(tnat.getSelectedItem()); // pour modifier
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controlleur.Factory.ModifyPatientID(idd,tp,nm,prn,gnr,dt,ad,tn,nat);
                afficher();
            }
        }
    }
     public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listePatient= Factory.getpatient();
        for(Patient t:listePatient){
            model.addRow(new Object[]{
                    t.getId_pat(),t.getNom(),t.getPrenom(),t.getGenre(),t.getDate(),t.getAdresse(),t.getNumerosoc(),t.getTelep(),t.getNational()}
            );
        }
         
     tbtechnicien=new JTable(model);
    JScrollPane p=new JScrollPane(tbtechnicien);
    p.setBounds(60,500,300,100);
    this.getContentPane().add(p);
    }
}
    