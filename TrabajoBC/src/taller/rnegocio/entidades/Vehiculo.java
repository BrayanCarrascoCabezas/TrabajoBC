package taller.rnegocio.entidades;
import java.util.*;
public class Vehiculo {
    private int cod_vehiculo;
    private Persona persona;
    private String marca;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(int cod_vehiculo, Persona persona, String marca, String modelo) {
        this.cod_vehiculo = cod_vehiculo;
        this.persona = persona;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCod_vehiculo() {
        return cod_vehiculo;
    }

    public void setCod_vehiculo(int cod_vehiculo) {
        this.cod_vehiculo = cod_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}