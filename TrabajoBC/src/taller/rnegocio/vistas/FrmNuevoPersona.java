/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.rnegocio.vistas;

/**
 *
 * @author Usuario
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class FrmNuevoPersona extends JInternalFrame{
    JLabel lblCodigo;
    JLabel lblNombres;
    JLabel lblTelefono;
    JLabel lblCedula;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtCedula;
    JTextField txtNombres;
    JTextField txtTelefono;    
      
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoPersona() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Persona");
        
        lblCodigo= new JLabel("Código:");
        lblCedula= new JLabel("Cédula:");
        lblNombres= new JLabel("Nombres:");
        lblTelefono= new JLabel("Teléfono:");
        txtCodigo = new JTextField(2);
        txtCedula= new JTextField(2);
        txtNombres= new JTextField(2);
        txtTelefono= new JTextField(2);        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblTelefono);
        pnlCentral.add(txtTelefono);
      
                
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoPersona frmMenu= new FrmNuevoPersona();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        
            Persona persona = new Persona();
            IPersona personaDao = new PersonaImp();
            persona.setCodigo(Integer.parseInt(txtCodigo.getText()));
            persona.setCedula(txtCedula.getText());
            persona.setNombre(txtNombres.getText());
           persona.setTelefono(txtTelefono.getText());
                        try {
                if(personaDao.insertar(persona)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
            
              
    }
}
 
