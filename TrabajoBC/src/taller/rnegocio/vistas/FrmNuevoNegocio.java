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

public class FrmNuevoNegocio extends JInternalFrame{
    JLabel lblCodigo;
    JLabel lblNombres;
    JLabel lblTelefono;
    JLabel lblDireccion;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtDireccion;
    JTextField txtNombres;
    JTextField txtTelefono;    
      
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoNegocio() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Negocio");
        
        lblCodigo= new JLabel("Código:");
        lblDireccion= new JLabel("Direccion:");
        lblNombres= new JLabel("Nombres:");
        lblTelefono= new JLabel("Teléfono:");
        txtCodigo = new JTextField(2);
        txtDireccion= new JTextField(2);
        txtNombres= new JTextField(2);
        txtTelefono= new JTextField(2);        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
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
        FrmNuevoNegocio frmMenu= new FrmNuevoNegocio();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        
            Negocio negocio = new Negocio();
            INegocio negocioDao = new NegocioImp();
            negocio.setCod_negocio(Integer.parseInt(txtCodigo.getText()));
            negocio.setDireccion(txtDireccion.getText());
            negocio.setNombre(txtNombres.getText());
           negocio.setTelefono(txtTelefono.getText());
                        try {
                if(negocioDao.insertar(negocio)>0 ){
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
 

