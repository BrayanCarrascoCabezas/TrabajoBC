package taller.rnegocio.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class FrmListaNegocio extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    JScrollPane jscTabla;
    DefaultTableModel modelo;
    public FrmListaNegocio(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de negocio");
    tabla = new JTable();
    jscTabla=new JScrollPane(tabla);
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(jscTabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
     modelo.addColumn("Codigo");
        modelo.addColumn("Persona");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        
        List<Negocio> lista = new ArrayList<>();
        try {
            INegocio negocioDao= new NegocioImp();
            lista = negocioDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Negocio est:lista){
            modelo.addRow(new Object[]{est.getCod_negocio(),est.getPersona().getCodigo(),est.getNombre(),est.getDireccion(),est.getTelefono().toString()});
        }
        tabla.setModel(modelo);
    }
}
