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
        Scanner entrada = new Scanner(System.in);

        Enlace c = new Enlace();
        entrada.useLocale(Locale.US);
        int opc;
        String continuar;

        do {

            System.out.println("\t------Plan Celular------\n"
                    + "Ingrese (1) para un Plan de Megas\n"
                    + "Ingrese (2) para un Plan de Minutos\n"
                    + "Ingrese (3) para un Plan de Megas y Minutos\n"
                    + "Ingrese (4) para un Plan de  Minutos y Megas Económico\n");
            opc = entrada.nextInt();

            entrada.nextLine();
            if (opc < 5 && opc >0) {
                System.out.println("Ingrese el nombre del Propietario:");
                String nom = entrada.nextLine();
                System.out.println("Ingrese el número de Cédula del Propietario:");
                String ced = entrada.nextLine();
                System.out.println("Ingrese la Ciudad del Propietario:");
                String ciu = entrada.nextLine();
                System.out.println("Ingrese la Marca del celular:");
                String mar = entrada.nextLine();
                System.out.println("Ingrese el Modelo del celular:");
                String mod = entrada.nextLine();
                System.out.println("Ingrese el Número de telefono:");
                String nume = entrada.nextLine();

                switch (opc) {
                    case 1 -> {
                        System.out.println("Ingrese el Número de Megas (Gb):");
                        int giga = entrada.nextInt();
                        System.out.println("Ingrese el Costo por Mega:");
                        double gicos = entrada.nextDouble();
                        PlanPostPagoMegas me = new PlanPostPagoMegas(nom, ced, ciu,
                                mar, mod, nume, giga, gicos, 12.0);
                        me.calcularPagoMensual();

                        c.insertarPlanMegas(me);
                    }
                    case 2 -> {
                        System.out.println("Ingrese el Número de Minutos nacionales:");
                        int mina = entrada.nextInt();
                        System.out.println("Ingrese el Costo por Minuto nacional:");
                        double cosMn = entrada.nextDouble();
                        System.out.println("Ingrese el Número de Minutos internacionales:");
                        int mini = entrada.nextInt();
                        System.out.println("Ingrese el Costo por Minuto internacional:");
                        double cosMi = entrada.nextDouble();
                        PlanPostPagoMinutos mi = new PlanPostPagoMinutos(nom, ced,
                                ciu, mar, mod, nume, mina, cosMn, mini, cosMi);
                        mi.calcularPagoMensual();

                        c.insertarPlanMinutos(mi);
                    }
                    case 3 -> {
                        System.out.println("Ingrese el Número de minutos:");
                        int min = entrada.nextInt();
                        System.out.println("Ingrese el Costo por minuto:");
                        double cost = entrada.nextDouble();
                        System.out.println("Ingrese el Número de Megas (Gb):");
                        int giga = entrada.nextInt();
                        System.out.println("Ingrese el Costo por Mega:");
                        double gicos = entrada.nextDouble();
                        PlanPostPagoMinutosMegas mm = new PlanPostPagoMinutosMegas(nom, ced,
                                ciu, mar, mod, nume, min, cost, giga, gicos);
                        mm.calcularPagoMensual();

                        c.insertarPlanMinutosMegas(mm);
                    }
                    case 4 -> {
                        System.out.println("Ingrese el Número de minutos:");
                        int min = entrada.nextInt();
                        System.out.println("Ingrese el Costo por minuto:");
                        double cost = entrada.nextDouble();
                        System.out.println("Ingrese el Número de Megas (Gb):");
                        int giga = entrada.nextInt();
                        System.out.println("Ingrese el Costo por Mega:");
                        double gicos = entrada.nextDouble();
                        PlanPostPagoMinutosMegasEconomico mmE = new PlanPostPagoMinutosMegasEconomico(nom, ced,
                                ciu, mar, mod, nume, min, cost, giga, gicos, 10);
                        mmE.calcularPagoMensual();

                        c.insertarPlanMinutosMegasEc(mmE);
                    }

                }
            }else{
                System.out.println("Numero fuera de rango");
                entrada.nextLine();
            }
            
            System.out.print("¿Desea ingresar otro Plan Celular?: ");
            
            continuar = entrada.nextLine();

        } while (continuar.toUpperCase().equals("S"));

        for (int i = 0; i < c.obtenerDataPlanMegas().size(); i++) {
            System.out.printf("%s", c.obtenerDataPlanMegas().get(i));
        }

        for (int i = 0; i < c.obtenerDataPlanMinutos().size(); i++) {
            System.out.printf("%s", c.obtenerDataPlanMinutos().get(i));
        }

        for (int i = 0; i < c.obtenerDataPlanMinutosMegas().size(); i++) {
            System.out.printf("%s", c.obtenerDataPlanMinutosMegas().get(i));
        }

        for (int i = 0; i < c.obtenerDataPlanMinutosMegasEconomico().size(); i++) {
            System.out.printf("%s", c.obtenerDataPlanMinutosMegasEconomico().get(i));
        }

    }
}
