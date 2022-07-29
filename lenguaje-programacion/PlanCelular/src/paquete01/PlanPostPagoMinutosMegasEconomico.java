/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author kevin
 */
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular {

    private int minutos;
    private double costoMinuto;
    private int megasGB;
    private double costoGB;
    private double porcentajeD;

    public PlanPostPagoMinutosMegasEconomico(String nom, String c, String cpr, String mcE,
            String mC, String nC, int min, double cm, int nm, double cGB, double x) {
        super(nom, c, cpr, mcE, mC, nC);
        minutos = min;
        costoMinuto = cm;
        megasGB = nm;
        costoGB = cGB;
        porcentajeD = x ;
    }

    public void establecerMinutos(int n) {
        minutos = n;
    }

    public void establecerCostoMinuto(double n) {
        costoMinuto = n;
    }

    public void establecerNumeroMegasGB(int n) {
        porcentajeD = n;
    }

    public void establecerCostoGB(double n) {
        costoGB = n;
    }

    public void establecerPDescuento(double n) {
        porcentajeD = n;
    }

    public int obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinuto() {
        return costoMinuto;
    }

    public int obtenerNumeroMegasGB() {
        return megasGB;
    }

    public double obtenerCostoGB() {
        return costoGB;
    }

    public double obtenerPDescuento() {
        return porcentajeD;
    }

    @Override
    public void calcularPagoMensual() {
        double subtotal = (minutos * costoMinuto)
                + (megasGB * costoGB);
        pagoM = subtotal - (((porcentajeD)/100) * subtotal);
    }

    @Override
    public double obtenerPagoMensual() {
        return pagoM;
    }

    @Override
    public String toString() {
        String cadena = String.format("------------------------------\n%s"
                + "Minutos: %d\n"
                + "Costo minuto : %.2f\n"
                + "Numero de Megas en GB: %d\n"
                + "Costo de Megas en GB: %.2f\n"
                + "Porcentage Descuento: %.2f\n"
                + "Pago mensual: %.2f\n",
                super.toString(),
                obtenerMinutos(),
                obtenerCostoMinuto(),
                obtenerNumeroMegasGB(),
                obtenerCostoGB(), 
                obtenerPDescuento(),
                obtenerPagoMensual());
        return cadena;
    }
}
