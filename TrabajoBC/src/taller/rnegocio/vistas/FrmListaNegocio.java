
package taller.rnegocio.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class FrmListaNegocio extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaNegocio(){
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("listado de estudiantes");
        tabla=new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("cod_negocio");
        modelo.addColumn("persona");
        modelo.addColumn("nombre");
        modelo.addColumn("direccion");
        modelo.addColumn("Ftelefono");
        List<Negocio> lista=new ArrayList<>();
        
        try{
            INegocio negocioDao =new NegocioImp();
            lista=negocioDao.obtener();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
            
        }
        for(Negocio est: lista) {
         modelo.addRow(new Object[]{est.getCod_negocio(),est.getPersona(),est.getNombre(), est.getDireccion(), est.getTelefono().toString()});
         
        }
        tabla.setModel(modelo);
}
}