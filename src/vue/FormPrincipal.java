
package vue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
//import controlleur.*;
//import modele.*;

public class FormPrincipal extends JFrame implements ActionListener {
    JMenuBar ba;
    JMenu mf,md,mt;
    JMenuItem imc,imt,itmat,itrep,imq;
    
    public FormPrincipal(){
         ba=new JMenuBar();
        
        mf= new JMenu("fichier");
        md=new JMenu("Données");
        mt=new JMenu("Traitement");
        
        imc=new JMenuItem("Patient");
        imc.addActionListener(this);
        imt=new JMenuItem("Chambre");
        imt.addActionListener(this);
        
         itmat=new JMenuItem("Admission");
        itmat.addActionListener(this);
        itrep=new JMenuItem("Nettoyeur");
        itrep.addActionListener(this);
        imq=new JMenuItem("Quitter");
        imq.addActionListener(this);
        
        md.add(imc);
        md.add(imt);
        md.add(itmat);
        md.add(itrep);
        mf.add(imq);
        ba.add(md);
        ba.add(mt);
        ba.add(mf);
        this.getContentPane().add(ba);
        ba.setBounds(10,10,500,30);
        this.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== imc){
            //ClientForm m= new ClientForm();
            FormPatient m= new FormPatient();
            m.setSize(800,600);
            m.setTitle("Gestion des Maitenances");
            m.setVisible(true);
        }
        else if(e.getSource()==imt){
            //TechnicienForm m = new TechnicienForm();
             FormChambre m= new  FormChambre();
            m.setSize(800,600);
            m.setTitle("Gestion des Maitenances");
            m.setVisible(true);
        }
        else if(e.getSource()==itmat){
             //MaterielForm m= new  MaterielForm();
            FormAdmission m= new  FormAdmission();
            m.setSize(800,600);
            m.setTitle("Gestion des Maitenances");
            m.setVisible(true);
        }
        else if(e.getSource()==itrep){
            FormNettoyeur m= new  FormNettoyeur();
            m.setSize(800,600);
            m.setTitle("Gestion des Maitenances");
            m.setVisible(true);
        }
        else if(e.getSource()== imq){
            dispose();
        }
    }
}

