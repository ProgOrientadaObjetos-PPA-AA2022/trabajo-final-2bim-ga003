/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.util.Locale;
import java.util.Scanner;
import paquete01.*;
import paquete03.Enlace;

/**
 *
 * @author kevin
 */
public class Principal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        PlanPostPagoMegas pagoM;
        PlanPostPagoMinutos pagoMi;
        PlanPostPagoMinutosMegas pagoMinMe;
        PlanPostPagoMinutosMegasEconomico pagoEconomico;
        Enlace c = new Enlace();
        leer.useLocale(Locale.US);
        int opc;
        int numM = 0;
        double costom = 0;
        int min = 0;
        double cost = 0;
        String bandera;

        do {
            System.out.println("[1] Ingresar un Plan de Megas");
            System.out.println("[2] Ingresar un Plan de Minutos");
            System.out.println("[3] Ingresar un Plan de Megas y Minutos");
            System.out.println("[4] Ingresar un Plan de  Minutos y Megas Económico");
            System.out.println("[5] Salir del Programa");
            opc = leer.nextInt();

            leer.nextLine();
            if (opc <= 5 && opc > 0) {
                if (opc == 5) {
                    System.out.println("Ha terminado de insertar planes.");
                    break;
                }
                System.out.println("Ingrese el nombre del Propietario:");
                String nombre = leer.nextLine();
                System.out.println("Ingrese el número de Cédula del Propietario:");
                String cedula = leer.nextLine();
                System.out.println("Ingrese la Ciudad del Propietario:");
                String ciudad = leer.nextLine();
                System.out.println("Ingrese la Marca del celular:");
                String marca = leer.nextLine();
                System.out.println("Ingrese el Modelo del celular:");
                String modelo = leer.nextLine();
                System.out.println("Ingrese el Número de telefono:");
                String num = leer.nextLine();

                switch (opc) {
                    case 1:
                        System.out.println("Ingrese el Número de Megas en GB:");
                        numM = leer.nextInt();
                        System.out.println("Ingrese el Costo por Mega:");
                        costom = leer.nextDouble();
                        System.out.println("Ingrese La Tarifa Base:");
                        int tarifa = leer.nextInt();
                        pagoM = new PlanPostPagoMegas(nombre, cedula, ciudad,
                                marca, modelo, num, numM, costom, tarifa);
                        pagoM.calcularPagoMensual();

                        c.insertarPlanMegas(pagoM);
                        break;

                    case 2:
                        System.out.println("Ingrese el Número de Minutos nacionales:");
                        int minNa = leer.nextInt();
                        System.out.println("Ingrese el Costo por Minuto nacional:");
                        double costMin = leer.nextDouble();
                        System.out.println("Ingrese el Número de Minutos internacionales:");
                        int minInter = leer.nextInt();
                        System.out.println("Ingrese el Costo por Minuto internacional:");
                        double costMinIn = leer.nextDouble();
                        pagoMi = new PlanPostPagoMinutos(nombre, cedula,
                                ciudad, marca, modelo, num, minNa, costMin, minInter, costMinIn);
                        pagoMi.calcularPagoMensual();

                        c.insertarPlanMinutos(pagoMi);
                        break;
                    case 3:
                        System.out.println("Ingrese el Número de minutos:");
                        min = leer.nextInt();
                        System.out.println("Ingrese el Costo por minuto:");
                        cost = leer.nextDouble();
                        System.out.println("Ingrese el Número de Megas en GB:");
                        numM = leer.nextInt();
                        System.out.println("Ingrese el Costo por Mega:");
                        costom = leer.nextDouble();
                        pagoMinMe = new PlanPostPagoMinutosMegas(nombre, cedula,
                                ciudad, marca, modelo, num, min, cost, numM, costom);
                        pagoMinMe.calcularPagoMensual();

                        c.insertarPlanMinutosMegas(pagoMinMe);
                        break;
                    case 4:
                        System.out.println("Ingrese el Número de minutos: ");
                        min = leer.nextInt();
                        System.out.println("Ingrese el Costo por minuto: ");
                        cost = leer.nextDouble();
                        System.out.println("Ingrese el Número de Megas en GB: ");
                        numM = leer.nextInt();
                        System.out.println("Ingrese el Costo por Mega: ");
                        costom = leer.nextDouble();
                        System.out.println("Ingrese el porcentaje de descuento: ");
                        int porcentaje = leer.nextInt();
                        pagoEconomico = new PlanPostPagoMinutosMegasEconomico(nombre, cedula,
                                ciudad, marca, modelo, num, min, cost, numM, costom, porcentaje);
                        pagoEconomico.calcularPagoMensual();

                        c.insertarEconomicoPlanMinutosMegas(pagoEconomico);

                        break;
                    default:
                        break;

                }
                leer.nextLine();
            } else {
                System.out.println("Numero fuera de rango");
            }

            System.out.println("-----------------------------------");
            System.out.println("[s] ingresar mas planes");
            System.out.println("[n] salir del Programa");

            bandera = leer.nextLine();

        } while (bandera.toUpperCase().equals("S"));
        
        
        System.out.println("------------Plan Megas-----------------------");
        for (int i = 0; i < c.obtenerPlanMegas().size(); i++) {
            System.out.printf("%s", c.obtenerPlanMegas().get(i));
        }
        System.out.println("------------Plan Minutos-----------------------");
        for (int i = 0; i < c.obtenerPlanMinutos().size(); i++) {
            System.out.printf("%s", c.obtenerPlanMinutos().get(i));
        }
        System.out.println("------------Plan Minutos y Megas-----------------------");
        for (int i = 0; i < c.obtenerPlanMinutosMegas().size(); i++) {
            System.out.printf("%s", c.obtenerPlanMinutosMegas().get(i));
        }
        System.out.println("------------Plan Economico de Megas y Minutos-----------------------");
        for (int i = 0; i < c.obtenerPlanEconomicoMinutosMegas().size(); i++) {
            System.out.printf("%s", c.obtenerPlanEconomicoMinutosMegas().get(i));
        }

    }
}
