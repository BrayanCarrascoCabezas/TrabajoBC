/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.rnegocio.vistas;

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

public class FrmNuevoVehiculo extends JInternalFrame{
    List<Persona> lstPersona;
    JComboBox<Persona> cmbPersona;
    JLabel lblCodigo;
    JLabel lblPersona;
    JLabel lblMarca;
    JLabel lblModelo;
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtMarca;
    JTextField txtModelo;
          
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoVehiculo() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Vehiculo");
        
        lblCodigo= new JLabel("Código:");
        lblPersona = new JLabel("Persona");
        lblMarca= new JLabel("Marca:");
        lblModelo= new JLabel("Modelo:");
        txtCodigo = new JTextField(2);
        cargarPersonas();
        cmbPersona= new JComboBox(lstPersona.toArray());
        txtMarca= new JTextField(2);
        txtModelo= new JTextField(2);
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblPersona);
        pnlCentral.add(cmbPersona);
        pnlCentral.add(lblMarca);
        pnlCentral.add(txtMarca);
        pnlCentral.add(lblModelo);
        pnlCentral.add(txtModelo);
     
                
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
    
     public void cargarPersonas(){
        IPersona personaDao = new PersonaImp();
        try {
            lstPersona = personaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los cursos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static void main(String[] args) {
        FrmNuevoVehiculo frmMenu= new FrmNuevoVehiculo();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        
            Vehiculo vehiculo = new Vehiculo();
            IVehiculo vehiculoDao = new VehiculoImp();
            vehiculo.setCod_vehiculo(Integer.parseInt(txtCodigo.getText()));
            vehiculo.setPersona((Persona) cmbPersona.getSelectedItem());
            vehiculo.setMarca(txtMarca.getText());
            vehiculo.setModelo(txtModelo.getText());
                                   try {
                if(vehiculoDao.insertar(vehiculo)>0 ){
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