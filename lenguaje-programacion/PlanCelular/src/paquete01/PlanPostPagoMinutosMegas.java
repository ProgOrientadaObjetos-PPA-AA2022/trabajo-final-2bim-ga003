/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author kevin
 */
public class PlanPostPagoMinutosMegas extends PlanCelular {

    private int minutos;
    private int megasGB;
    private double costoGB;
    private double costoMinuto;

    public PlanPostPagoMinutosMegas(String nom, String c, String cpr, String mcE,
            String mC, String nC, int nM, double cm, int nmG, double cG) {
        super(nom, c, cpr, mcE, mC, nC);
        minutos = nM;
        costoMinuto = cm;
        megasGB = nmG;
        costoGB = cG;
    }

    public void establecerMinutos(int c) {
        minutos = c;
    }

    public void establecerCostoMinuto(double c) {
        costoMinuto = c;
    }

    public void establecerNumeroMegasGB(int c) {
        megasGB = c;
    }

    public void establecerCostoGB(double c) {
        costoGB = c;
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

    @Override
    public void calcularPagoMensual() {
        pagoM = (minutos * costoMinuto)
                + (megasGB * costoGB);
    }

    @Override
    public String toString() {
        String cadena = String.format("\nPlan PostPago MinutosMegas\n"
                + super.toString() + "\nReporte\n"
                + "\tMinutos: %d\n"
                + "\tCosto minuto : %.2f\n"
                + "\tNumero de Megas (GB): %d\n"
                + "\tCosto del GB: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMinutos(), obtenerCostoMinuto(),
                obtenerNumeroMegasGB(),
                obtenerCostoGB(),
                obtenerPagoMensual());
        return cadena;
    }
}
