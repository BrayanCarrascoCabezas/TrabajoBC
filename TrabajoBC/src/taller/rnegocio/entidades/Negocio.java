package taller.rnegocio.entidades;
public class Negocio {
    private int cod_negocio;  
    private Persona persona;
      private String nombre;
      private String direccion;
      private String telefono;

    public Negocio() {
    }

    public Negocio(int cod_negocio, Persona persona, String nombre, String direccion, String telefono) {
        this.cod_negocio = cod_negocio;
        this.persona = persona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getCod_negocio() {
        return cod_negocio;
    }

    public void setCod_negocio(int cod_negocio) {
        this.cod_negocio = cod_negocio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
      
}
