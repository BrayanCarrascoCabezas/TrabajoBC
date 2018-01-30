package taller.Test;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import taller.rnegocio.dao.*;
import taller.rnegocio.entidades.*;
import taller.rnegocio.impl.*;

public class PersonaTest {
    public PersonaTest() {
    }
    @Test
    public void pruebageneral(){
        //              INSERTAR
        int filasAfectadas =0;
        IPersona personaDao = new PersonaImp();
        Persona persona = new Persona(4,"Bryan","0969696","172204682");
        try{
            filasAfectadas = personaDao.insertar(persona);
            System.out.println("Persona ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);
        //              LISTADO DE PEdido
        List<Persona> lista = new ArrayList<>();
        try {
            lista = personaDao.obtener();
            for (Persona c:lista){
                System.out.println("---Datos personas---");
                System.out.println("Id :"+c.getCodigo());
                System.out.println("Nombre :"+c.getNombre());
                System.out.println("Telefono :"+c.getTelefono());
            System.out.println("Cedula :"+c.getCedula());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }

}


