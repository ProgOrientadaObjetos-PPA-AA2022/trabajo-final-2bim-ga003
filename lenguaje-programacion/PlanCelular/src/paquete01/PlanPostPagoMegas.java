/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author kevin
 */
public class PlanPostPagoMegas extends PlanCelular {

    private int megasGB;
    private double costoGB;
    private double tarifa;

    public PlanPostPagoMegas(String nom, String c, String cpr, String mcE,
            String mC, String nC, int nM, double cG, double t) {
        super(nom, c, cpr, mcE, mC, nC);
        megasGB = nM;
        costoGB = cG;
        tarifa = t;
    }

    public void establecerNumeroMegasGB(int c) {
        megasGB = c;
    }

    public void establecerCostoGB(double c) {
        costoGB = c;
    }

    public void establecerTarifaBase(double c) {
        tarifa = c;
    }

    public int obtenerNumeroMegasGB() {
        return megasGB;
    }

    public double obtenerCostoGB() {
        return costoGB;
    }

    public double obtenerTarifaBase() {
        return tarifa;
    }

    @Override
    public void calcularPagoMensual() {
        pagoM = tarifa + (megasGB * costoGB);
    }

    @Override
    public String toString() {
        String cadena = String.format("\nPlan PostPago Megas\n"
                + super.toString() + "\nReporte\n"
                + "\tNumero de Megas (GB): %d\n"
                + "\tCosto del GB: %.2f\n"
                + "\tTarifa base: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerNumeroMegasGB(), obtenerCostoGB(),
                obtenerTarifaBase(),
                obtenerPagoMensual());
        return cadena;
    }
}
