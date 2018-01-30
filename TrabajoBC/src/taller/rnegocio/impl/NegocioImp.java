package taller.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import taller.accesodatos.*;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;

public class NegocioImp implements INegocio{

    @Override
    public int insertar(Negocio negocio ) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into negocio values(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, negocio.getCod_negocio()));
        lstPar.add(new Parametro(3, negocio.getNombre()));
        lstPar.add(new Parametro(4, negocio.getDireccion()));
        lstPar.add(new Parametro(5, negocio.getTelefono()));
        lstPar.add(new Parametro(2, negocio.getPersona().getCodigo()));
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
    @Override
    public List<Negocio> obtener() throws Exception{
        List<Negocio> lista = new ArrayList<>();
        
        String sql="SELECT * FROM negocio;";
        Conexion con = null;
        try{
            Negocio negocio = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()){
                negocio = new Negocio();
                negocio.setCod_negocio(rst.getInt(1));
                negocio.setNombre(rst.getString(3));
                negocio.setDireccion(rst.getString(4));
               negocio.setTelefono(rst.getString(5));
               IPersona personadao = new PersonaImp();
                Persona persona = personadao.obtener(rst.getInt(2));
                negocio.setPersona(persona);
                lista.add(negocio);
           }
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
    @Override
    public Negocio obtener(int codigo) throws Exception{
        
        return null;
    }  
}