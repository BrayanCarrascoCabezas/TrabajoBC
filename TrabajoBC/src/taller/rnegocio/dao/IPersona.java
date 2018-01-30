package taller.rnegocio.dao;
import taller.rnegocio.entidades.*;
import java.util.List;

public interface IPersona {
     public int insertar(Persona persona) throws Exception;
     public List<Persona> obtener() throws Exception;
         public Persona obtener(int codigo) throws Exception;  
}
