
package vue;
import controlleur.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import vue.*;
import modele.*;
public class FormChambre extends JFrame implements ActionListener{
     JLabel lidchamb, lnumCh,lcat,lcap,lpri;
        JTextField tid,tnumCh,tcap, tpri;
        JComboBox listecat;
        JButton ajout,aff, rech, supp, reini, modif;
        String[] tcat={"","Salle","Chambre","VIP"};
        
        ArrayList<Chambre> listeChambre=new ArrayList();
        JTable tbchambre;
        private final DefaultTableModel model;
        Chambre c = new Chambre();
        Chambre ch=null;
        
         public FormChambre(){
        
        lidchamb=new JLabel("No");
        lidchamb.setBounds(10,30,100,30);
        this.getContentPane().add(lidchamb);
        
        tid=new JTextField("");
        tid.setBounds(120,30,100,30);
        this.getContentPane().add(tid);
        
          rech=new JButton("Rechercher");
        rech.setBounds(230,30,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        lnumCh=new JLabel("No de la chambre");
        lnumCh.setBounds(10,70,100,30);
        this.getContentPane().add(lnumCh);
        
        tnumCh=new JTextField("");
        tnumCh.setBounds(120,70,100,30);
        this.getContentPane().add(tnumCh);
        
        lcap=new JLabel("Capacite");
        lcap.setBounds(10,110,100,30);
        this.getContentPane().add(lcap);
        
        tcap=new JTextField("");
        tcap.setBounds(120,110,100,30);
        this.getContentPane().add(tcap);
        
        lcat=new JLabel("Catégorie :");
        lcat.setBounds(10,180,100,30);
        this.getContentPane().add(lcat);
        listecat=new JComboBox(tcat);
        listecat.setBounds(120,180,100,30);
        listecat.addActionListener(this);
        this.getContentPane().add(listecat);
        
        lpri=new JLabel("Prix :");
       lpri.setBounds(10,230,100,30);
        this.getContentPane().add(lpri);
        tpri=new JTextField();
        tpri.setBounds(120,230,100,30);
        //tpri.setEditable(false);
        tpri.addActionListener(this);
        this.getContentPane().add(tpri);
          
        ajout=new JButton("Enregistrer");
        ajout.setBounds(10,350,100,30);
        ajout.addActionListener(this); // ecouteur 
        this.getContentPane().add(ajout);
        
        aff=new JButton("Visualiser");
        aff.setBounds(120,350,100,30);
        aff.addActionListener(this); // ecouteurs
        this.getContentPane().add(aff);
        
        reini=new JButton("Initialiser");
        reini.setBounds(230,350,100,30);
        reini.addActionListener(this);
        this.getContentPane().add(reini);
        
        supp=new JButton("Supprimer");
        supp.setBounds(340,350,100,30);
        supp.addActionListener(this);
        this.getContentPane().add(supp);
        
        modif=new JButton("Modifier");
        modif.setBounds(450,350,100,30);
        modif.addActionListener(this);
        this.getContentPane().add(modif);
        
       model=new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Numero");
        model.addColumn("Capacite");
        model.addColumn("Prix");
        model.addColumn("Type Chambre");
        
        
        this.setLayout(null);
         }
          public void effacer(){
        tid.setText("");
        tnumCh.setText("");
        tcap.setText("");
        tpri.setText("");
        listecat.setSelectedIndex(-1);
        //ttel.setText("");
    }
           public void recupInfo(Chambre c){ // les affichages apres avoir cliquer sur le bouton rechercher
        
        tid.setText(String.valueOf(c.getIdchamb()));
        tnumCh.setText(String.valueOf(c.getNumero_cha()));
        tcap.setText(String.valueOf(c.getCapacite()));
        tpri.setText(String.valueOf(c.getPrix_nuit()));
        listecat.setSelectedItem(c.getType_chambre());
       
    }
         public void actionPerformed(ActionEvent e){
             if(e.getSource()==ajout){
             int id=Integer.valueOf(tid.getText());
             int no=Integer.valueOf(tnumCh.getText());
             int cap=Integer.valueOf(tcap.getText());
             String categ=String.valueOf(listecat.getSelectedItem());
             int pr=Integer.valueOf(tpri.getText());
             c= new Chambre(id,no,cap,pr,categ);
             Factory.insererChambre(c);
             }
             else if(e.getSource()==aff){
                 afficher();
             }else if(e.getSource()==reini){
            effacer();
        }else if(e.getSource()==supp){
            if(ch !=null){
                String msg="Voulez-vous reelement supprimer "+ch.getIdchamb()+" de la liste des clients";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory.DeleteChambre(ch);
                    afficher();
                    effacer();
                }
            }
        }
             else if(e.getSource()==rech){ // bouton pour la recherche
            int ct=Integer.valueOf(tid.getText());
            ch=Factory.getChambreID(ct);
            if(ch!=null){
                recupInfo(ch);
            }
        } else if(e.getSource()==modif){ // bouton pour la modification
            int idd=Integer.valueOf(tid.getText());
            int not=Integer.valueOf(tnumCh.getText());
             int capn=Integer.valueOf(tcap.getText());
              int pro=Integer.valueOf(tpri.getText());
             String categc=String.valueOf(listecat.getSelectedItem());
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
               controlleur.Factory.ModifyChambreID(idd,not,capn,pro,categc);
                afficher();
            }
        }
         }
           public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        listeChambre= Factory.getchambre(); // j'ai juste fait appel a un membre d'une instance ici 
        for(Chambre c:listeChambre){
            model.addRow(new Object[]{
                    c.getIdchamb(),c.getNumero_cha(),c.getCapacite(),c.getPrix_nuit(),c.getType_chambre()} // selon le constructeur
            );
        }
         
        tbchambre=new JTable(model);
    JScrollPane p=new JScrollPane(tbchambre);
    p.setBounds(60,500,300,100);
    this.getContentPane().add(p);
    }
}
