/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import taller.rnegocio.dao.*;
import taller.rnegocio.impl.*;
import taller.rnegocio.entidades.*;
public class Frmlistapersona extends JInternalFrame{
    
JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;
    public Frmlistapersona(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de persona");
    tabla = new JTable();
    jscTabla=new JScrollPane(tabla);
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(jscTabla,BorderLayout.CENTER);
        cargarTabla();
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Telefono");
     
        List<Persona> lista=new ArrayList<>();
        
        try{
            IPersona personaDao =new PersonaImp();
            lista=personaDao.obtener();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
            
        }
        for(Persona est: lista) {
         modelo.addRow(new Object[]{est.getCodigo(),est.getCedula(),est.getNombre(),est.getTelefono().toString()});
         
        }
        tabla.setModel(modelo);
}
}
