
package taller.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class VehiculoTest {
    public VehiculoTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        IVehiculo vehiculoDao = new VehiculoImp();
        IPersona personaDao = new PersonaImp();
        Persona persona = personaDao.obtener(3);
        Vehiculo vehiculo = new Vehiculo(3,persona,"NIssan","2015");
        try{
            filasAfectadas = vehiculoDao.insertar(vehiculo);
            System.out.println("Vehiculo ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error:.. "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        
        //              LISTADO DE PEdido
        List<Vehiculo> lista = new ArrayList<>();
        try {
            lista = vehiculoDao.obtener();
            for (Vehiculo c:lista){
                System.out.println("---Datos vehiculos---");
                System.out.println("Id_persona :"+c.getPersona().getCodigo());
                System.out.println("Codigo :"+c.getCod_vehiculo());
                System.out.println("Marca  :"+c.getMarca());
            System.out.println("Modelo :"+c.getModelo());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}

