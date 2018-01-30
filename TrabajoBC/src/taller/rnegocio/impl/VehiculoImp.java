package taller.rnegocio.impl;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import taller.accesodatos.*;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;

public class VehiculoImp implements IVehiculo{

    @Override
    public int insertar(Vehiculo vehiculo ) throws Exception{
        int numFilasAfectadas=0;
        String sql="insert into vehiculo values"+ "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, vehiculo.getCod_vehiculo()));
        lstPar.add(new Parametro(3, vehiculo.getMarca()));
        lstPar.add(new Parametro(4, vehiculo.getModelo()));
        lstPar.add(new Parametro(2, vehiculo.getPersona().getCodigo()));
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
    public List<Vehiculo> obtener() throws Exception{
        List<Vehiculo> lista = new ArrayList<>();
        
        String sql="SELECT * FROM vehiculo;";
        Conexion con = null;
        try{
            Vehiculo vehiculo = null;
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            while (rst.next()){
                vehiculo = new Vehiculo();
                vehiculo.setCod_vehiculo(rst.getInt(1));
                vehiculo.setMarca(rst.getString(3));
                vehiculo.setModelo(rst.getString(4));
                IPersona personadao = new PersonaImp();
                Persona persona = personadao.obtener(rst.getInt(2));
                vehiculo.setPersona(persona);
                lista.add(vehiculo);
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
    public Vehiculo obtener(int codigo) throws Exception{
        return null;
        
    }  
}