/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author kevin
 */
public class PlanPostPagoMinutos extends PlanCelular {

    private int minutosNacionales;
    private double costoMinutoNacional;
    private int minutosInternacionales;
    private double costoMinutoInternacional;

    public PlanPostPagoMinutos(String nom, String c, String cpr, String mcE,
            String mC, String nC, int mn, double m, int mi, double cmi) {
        super(nom, c, cpr, mcE, mC, nC);
        minutosNacionales = mn;
        costoMinutoNacional = m;
        minutosInternacionales = mi;
        costoMinutoInternacional = cmi;
    }

    public void establecerMinutosNacionales(int c) {
        minutosNacionales = c;
    }
    public void establecerCostoMinutoNacional(double c) {
        costoMinutoNacional = c;
    }
    public void establecerMinutosInternacionales(int c) {
        minutosInternacionales = c;
    }
    public void establecerCostoMinutoInternacional(double c) {
        costoMinutoInternacional = c;
    }
    
    public int obtenerMinutosNacionales() {
        return minutosNacionales;
    }
    public double obtenerCostoMinutoNacional() {
        return costoMinutoNacional;
    }
    public int obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public double obtenerCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    @Override
    public void calcularPagoMensual() {
        pagoM = (obtenerMinutosNacionales() * obtenerCostoMinutoNacional())
                + (obtenerMinutosInternacionales() * obtenerCostoMinutoInternacional());
    }
    @Override
    public String toString() {
        String cadena = String.format("------------------------------\n%s"
                + "Minutos nacionales: %d\n"
                + "Costo minuto nacional: %.2f\n"
                + "Minutos internacionales: %d\n"
                + "Costo minutos internacionales: %.2f\n"
                + "Pago mensual: %.2f\n",
                super.toString(),
                obtenerMinutosNacionales(),
                obtenerCostoMinutoNacional(),
                obtenerMinutosInternacionales(),
                obtenerCostoMinutoInternacional(),
                obtenerPagoMensual());
        return cadena;
    }
}
