
package vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import vue.*;
import modele.*;
import controlleur.*;

public class FormNettoyeur extends JFrame implements ActionListener{
    JLabel lid,lnom,lprenom,lhoraire,ltele,lch;
    JTextField tid,tnom,tprenom,thoraire,ttele;
    JComboBox tch;
    JButton enr,vis,init,del,rech,upd;
    ArrayList <Nettoyeur> listeNettoyeur= new ArrayList();
    ArrayList <Chambre> listeChambre= new ArrayList();
    JTable tbmateriel;
    private final DefaultTableModel model;
    Nettoyeur mt=new Nettoyeur();
    Nettoyeur mtr=null;
    int index=0;
    
    public FormNettoyeur(){
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
        
        lprenom=new JLabel("Prenom");
        lprenom.setBounds(10,110,100,30);
        this.getContentPane().add(lprenom);
        
        tprenom=new JTextField("");
        tprenom.setBounds(120,110,100,30);
        this.getContentPane().add(tprenom);
        
        lhoraire=new JLabel("Horaire");
        lhoraire.setBounds(10,150,100,30);
        this.getContentPane().add(lhoraire);
        
        thoraire=new JTextField("");
        thoraire.setBounds(120,150,100,30);
        this.getContentPane().add(thoraire);
        
        ltele=new JLabel("Telephone");
        ltele.setBounds(10,190,100,30);
        this.getContentPane().add(ltele);
        
        ttele=new JTextField("");
        ttele.setBounds(120,190,100,30);
        this.getContentPane().add(ttele);
        
        lch=new JLabel("Chambre");
        lch.setBounds(10,250,100,30);
        this.getContentPane().add(lch);
        
         tch=new JComboBox();
        listeChambre=Factory.getchambre();
        for(Chambre c:listeChambre){
            tch.addItem(c.getIDChambre());
        }
        tch.setBounds(120,250,150,30);
        tch.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=tch.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(tch);
        
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
        model.addColumn("Nom du Nettoyeur");
        model.addColumn("Prenom du Nettoyeur");
        model.addColumn("Horaire");
        model.addColumn("Telephone");
        model.addColumn("Chambre");
        
        this.setLayout(null);
        
}
     public void effacer(){
        tid.setText("");
        tnom.setText("");
        tprenom.setText("");
        thoraire.setText("");
        ttele.setText("");
    }
     public void recupInfo(Nettoyeur m){
        //tnum.setText(cr.getNum());
        tid.setText(String.valueOf(m.getIdnet()));
        tnom.setText(m.getNomn());
        tprenom.setText(m.getPrenomn());
        thoraire.setText(m.getHoraire());
        ttele.setText(String.valueOf(m.getTeleph()));
        String etr=getChambre(m.getId_cham());
        tch.setSelectedItem(etr);
    }
      public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeNettoyeur= Factory.getnettoyeur();
        for(Nettoyeur m:listeNettoyeur){
            model.addRow(new Object[]{
                    m.getIdnet(),m.getNomn(),m.getPrenomn(),m.getHoraire(),m.getTeleph(),m.getId_cham()}
            );
        }
         
        tbmateriel=new JTable(model);
    JScrollPane p=new JScrollPane(tbmateriel);
    p.setBounds(60,500,300,100);
    this.getContentPane().add(p);
    }
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==enr){
            int m=Integer.valueOf(tid.getText());
            String n=tnom.getText();
            String p=tprenom.getText();
            String c=thoraire.getText();
            int te=Integer.valueOf(ttele.getText());
           // String  te =ttele.getText();
            int idcha=listeChambre.get(index).getIdchamb(); // ici on prend la l'affichage la ou est la clef + son get definie dans sa chambre
            // apres avoir recueper le donnees saisies au clavier il faut construire alors l'objet donc l'instanciation
            mt=new Nettoyeur(m,idcha,te,n,p,c);
            Factory.insererNettoyeur(mt);
        } else if(e.getSource()==vis){
            afficher();
        } else if(e.getSource()==init){
            effacer();
        } else if(e.getSource()==del){
            if(mtr !=null){
                String msg="Voulez-vous reelement supprimer "+mtr.getNomn()+" de la liste des Nettoyeurs";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeleteNettoyeur(mtr);
                    afficher();
                    effacer();
                }
            }
        }else if(e.getSource()==rech){
            int ct=Integer.valueOf(tid.getText());
            mtr=Factory.getnettoyeurID(ct);  // donc nous appelons notre methode ici
            if(mtr!=null){
                recupInfo(mtr);
            }
        }else if(e.getSource()==upd){
            int idd=Integer.valueOf(tid.getText());
            String nm=tnom.getText();
            String ma=tprenom.getText();
            String cat=thoraire.getText();
            int tep=Integer.valueOf(ttele.getText());
            int cli=listeChambre.get(index).getIdchamb(); // ici on prend dans la classe chambre
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controlleur.Factory.ModifyNettoyeurID(idd,cli,nm,ma,cat,tep); // un constructeur comme on la fait en update
                afficher();
            }
        }
        
      }
      String getChambre(int num){
        String nume="";
        for(Chambre ch:listeChambre){
            if(ch.getIdchamb()==num){
                nume=ch.getIDChambre();
                break;
            }
        }return nume;
    }
}
