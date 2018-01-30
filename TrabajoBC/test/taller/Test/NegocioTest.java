package taller.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class NegocioTest {
    public NegocioTest() {
    }
    @Test
    public void pruebageneral() throws Exception{
        //              INSERTAR
        int filasAfectadas =0;
        INegocio negocioDao = new NegocioImp();
        IPersona personaDao = new PersonaImp();
        Persona persona = personaDao.obtener(3);
        Negocio negocio = new Negocio(4,persona,"Hamburguesas","Orozco y darquea","096564987");
        try{
            filasAfectadas = negocioDao.insertar(negocio);
            System.out.println("Negocio ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Negocio> lista = new ArrayList<>();
        try {
            lista = negocioDao.obtener();
            for (Negocio c:lista){
                System.out.println("---Datos negocios---");
                System.out.println("Id_persona :"+c.getPersona().getCodigo());
                System.out.println("Codigo :"+c.getCod_negocio());
                System.out.println("NOmbre  :"+c.getNombre());
            System.out.println("Direccion :"+c.getDireccion());
            System.out.println("Telefono :"+c.getTelefono());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}
