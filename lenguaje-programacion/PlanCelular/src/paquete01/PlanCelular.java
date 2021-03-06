/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete01;

/**
 *
 * @author kevin
 */
public abstract class PlanCelular {
    protected String nombrePropietario;
    protected String cedula;
    protected String ciudad;
    protected String marca;
    protected String modelo;
    protected String numero;
    protected double pagoM;

    public PlanCelular(String nom, String c, String cpr, String mcE,String mC, String nC) {
        nombrePropietario = nom;
        cedula = c;
        ciudad = cpr;
        marca = mcE;
        modelo = mC;
        numero = nC;
    }

    public void establecerNombrePropietario(String c) {
        nombrePropietario = c;
    }
    public void establecerCedulaPropietario(String c) {
        cedula = c;
    }
    public void establecerCiudadPropietario(String c) {
        ciudad = c;
    }
    
    public String obtenerNombresPropietario() {
        return nombrePropietario;
    }
    public void establecerMarcaCelular(String c) {
        marca = c;
    }
    public void establecerModeloCelular(String c) {
        modelo = c;
    }
    public void establecerNumeroCelular(String c) {
        numero = c;
    }
    public abstract void calcularPagoMensual();

    
    public String obtenerCedulaPropietario() {
        return cedula;
    }

    public String obtenerCiudadPropietario() {
        return ciudad;
    }
    public String obtenerMarcaCelular() {
        return marca;
    }
    public String obtenerModeloCelular() {
        return modelo;
    }
    public String obtenerNumeroCelular() {
        return numero;
    }
    public double obtenerPagoMensual() {
        return pagoM;
    }

    @Override
    public String toString() {
        String cadena = String.format("Nombres del Propietario: %s\n"
                + "Ciudad del Propietario: %s\n"
                + "Cedula del Propietario: %s\n"
                + "Marca del Celular: %s\n"
                + "Modelo: %s\n"
                + "Numero: %s\n",
                obtenerNombresPropietario(),
                obtenerCiudadPropietario(),
                obtenerCedulaPropietario(), 
                obtenerMarcaCelular(),
                obtenerModeloCelular(), 
                obtenerNumeroCelular());

        return cadena;
    }
    
}
