package taller.rnegocio.dao;
import taller.rnegocio.entidades.*;
import java.util.List;

public interface INegocio {
     public int insertar( Negocio negocio) throws Exception;
     public List<Negocio> obtener() throws Exception;
     public Negocio obtener(int codigo) throws Exception;   
}
