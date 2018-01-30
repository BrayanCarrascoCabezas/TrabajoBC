/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import taller.rnegocio.*;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JMenu mnPersona;
    JMenuItem mniNuevoPersona;
    JMenuItem mniModificaPersona;
    JMenuItem mniEliminaPersona;
    JMenuItem mniBuscaPersona;
    JMenuItem mniListaPersona;
    JMenu mnVehiculo;
    JMenuItem mniNuevoVehiculo;
    JMenuItem mniModificaVehiculo;
    JMenuItem mniEliminaVehiculo;
    JMenuItem mniListaVehiculo;
    JMenuItem mniBuscaVehiculo;
    JMenu mnNegocio;
    JMenuItem mniNuevoNegocio;
    JMenuItem mniModificaNegocio;
    JMenuItem mniEliminaNegocio;
    JMenuItem mniBuscaNegocio;
    JMenuItem mniListaNegocio;

    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        mnPersona= new JMenu("Persona");
        mniNuevoPersona= new JMenuItem("Nuevo");
        mniNuevoPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPersonaActionPerformed(e);
            }
        });
        mniModificaPersona= new JMenuItem("Modifica");
        mniEliminaPersona= new JMenuItem("Elimina");
        mniBuscaPersona= new JMenuItem("Busca");
        mniListaPersona= new JMenuItem("Lista");
        mniListaPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaPersonaActionPerformed(e);
            }
        });
        mnPersona.add(mniNuevoPersona);
        mnPersona.add(mniModificaPersona);
        mnPersona.add(mniEliminaPersona);
        mnPersona.addSeparator();
        mnPersona.add(mniBuscaPersona);
        mnPersona.add(mniListaPersona);
        
        mnNegocio= new JMenu("Negocio");
        mniNuevoNegocio= new JMenuItem("Nuevo");
        mniNuevoNegocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoNegocioActionPerformed(e);
            }
        });
        mniModificaNegocio= new JMenuItem("Modifica");
        mniEliminaNegocio= new JMenuItem("Elimina");
        mniBuscaNegocio= new JMenuItem("Busca");
        mniListaNegocio= new JMenuItem("Lista");
        mniListaNegocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaNegocioActionPerformed(e);
            }
        });
        
        mnNegocio.add(mniNuevoNegocio);
        mnNegocio.add(mniModificaNegocio);
        mnNegocio.add(mniEliminaNegocio);
        mnNegocio.addSeparator();
        mnNegocio.add(mniBuscaNegocio);
        mnNegocio.add(mniListaNegocio);
        
        mnVehiculo = new JMenu("Vehiculo");
        mniNuevoVehiculo = new JMenuItem("Nuevo");
        mniNuevoVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVehiculoActionPerformed(e);
            }
        });
        mniModificaVehiculo = new JMenuItem("Modifica");
        mniEliminaVehiculo = new JMenuItem("Elimina");
        mniBuscaVehiculo = new JMenuItem("Busca");
        mniListaVehiculo = new JMenuItem("Lista");
        
        mniListaVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVehiculoActionPerformed(e);
            }
        });
        
        mnVehiculo.add(mniNuevoVehiculo);
        mnVehiculo.add(mniModificaVehiculo);
        mnVehiculo.add(mniEliminaVehiculo);
        mnVehiculo.addSeparator();
        mnVehiculo.add(mniBuscaVehiculo);
        mnVehiculo.add(mniListaVehiculo);
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnPersona);
        mnbPrincipal.add(mnNegocio);
        mnbPrincipal.add(mnVehiculo);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    }
   public void mniNuevoPersonaActionPerformed(ActionEvent e){
        FrmNuevoPersona frm = new FrmNuevoPersona();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniNuevoNegocioActionPerformed(ActionEvent e){
        FrmNuevoNegocio frm = new FrmNuevoNegocio();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
        public void mniNuevoVehiculoActionPerformed(ActionEvent e)
    {
        FrmNuevoVehiculo frm= new FrmNuevoVehiculo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }

    
    public void mniListaPersonaActionPerformed(ActionEvent e)
    {
    FrmListaPersona frm= new FrmListaPersona();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    public void mniListaVehiculoActionPerformed(ActionEvent e)
    {
    FrmListaVehiculo frm= new FrmListaVehiculo();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
     public void mniListaNegocioActionPerformed(ActionEvent e)
    {
    FrmListaNegocio frm= new FrmListaNegocio();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    public static void main(String[] args) {
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}
