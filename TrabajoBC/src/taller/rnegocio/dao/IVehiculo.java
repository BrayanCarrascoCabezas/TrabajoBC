
package taller.rnegocio.dao;
import taller.rnegocio.entidades.*;
import java.util.List;

public interface IVehiculo {
     public int insertar(Vehiculo vehiculo) throws Exception;
     public Vehiculo obtener(int codigo) throws Exception;
    public List<Vehiculo> obtener() throws Exception;
    
}
