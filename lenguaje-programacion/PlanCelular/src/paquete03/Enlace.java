/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete01.*;

/**
 *
 * @author kevin
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base01.db";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPlanMinutos(PlanPostPagoMinutos planm) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            planm.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMinutos "
                    + "(nombresPropietario,"
                    + "cedulaPropietario,ciudadPropietario,marcaCelular,"
                    + "modeloCelular,numeroCelular,minutosNacionales,"
                    + "costoMinutoNacional,minutosInternacionales,"
                    + "costoMinutoInternacional,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s)",
                    planm.obtenerNombresPropietario(),
                    planm.obtenerCedulaPropietario(),
                    planm.obtenerCiudadPropietario(),
                    planm.obtenerMarcaCelular(),
                    planm.obtenerModeloCelular(),
                    planm.obtenerNumeroCelular(),
                    planm.obtenerMinutosNacionales(),
                    planm.obtenerCostoMinutoNacional(),
                    planm.obtenerMinutosInternacionales(),
                    planm.obtenerCostoMinutoInternacional(),
                    planm.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutos> obtenerDataPlanMinutos() {
        ArrayList<PlanPostPagoMinutos> lista1 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos planm = new PlanPostPagoMinutos(
                        rs.getString("nombresPropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutosNacionales"),
                        rs.getDouble("costoMinutoNacional"),
                        rs.getInt("minutosInternacionales"),
                        rs.getDouble("costoMinutoInternacional"));
                planm.calcularPagoMensual();
                lista1.add(planm);

            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanMinutos");
            System.out.println(e.getMessage());

        }
        return lista1;
    }

    public void insertarPlanMegas(PlanPostPagoMegas planme) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            planme.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMegas "
                    + "(nombresPropietario,"
                    + "cedulaPropietario,ciudadPropietario,marcaCelular,"
                    + "modeloCelular,numeroCelular,numeroMegasGB,costoGB,"
                    + "tarifaBase,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + " %s, %s)",
                    planme.obtenerNombresPropietario(),
                    planme.obtenerCedulaPropietario(),
                    planme.obtenerCiudadPropietario(),
                    planme.obtenerMarcaCelular(),
                    planme.obtenerModeloCelular(),
                    planme.obtenerNumeroCelular(),
                    planme.obtenerNumeroMegasGB(),
                    planme.obtenerCostoGB(),
                    planme.obtenerTarifaBase(),
                    planme.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMegas> obtenerDataPlanMegas() {
        ArrayList<PlanPostPagoMegas> lista2 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMegas planme = new PlanPostPagoMegas(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedula"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getInt("megasGB"),
                        rs.getDouble("costoGB"),
                        rs.getDouble("tarifa"));
                planme.calcularPagoMensual();
                lista2.add(planme);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanMegas");
            System.out.println(e.getMessage());

        }
        return lista2;
    }

    public void insertarPlanMinutosMegas(PlanPostPagoMinutosMegas planmm) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            planmm.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegas "
                    + "(nombresPropietario,"
                    + "cedulaPropietario,ciudadPropietario,marcaCelular,"
                    + "modeloCelular,numeroCelular,minutos,"
                    + "costoMinuto,numeroMegasGB,"
                    + "costoGB,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s)",
                    planmm.obtenerNombresPropietario(),
                    planmm.obtenerCedulaPropietario(),
                    planmm.obtenerCiudadPropietario(),
                    planmm.obtenerMarcaCelular(),
                    planmm.obtenerModeloCelular(),
                    planmm.obtenerNumeroCelular(),
                    planmm.obtenerMinutos(),
                    planmm.obtenerCostoMinuto(),
                    planmm.obtenerNumeroMegasGB(),
                    planmm.obtenerCostoGB(),
                    planmm.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutosMegas> obtenerDataPlanMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegas> lista3 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegas planmm = new PlanPostPagoMinutosMegas(
                        rs.getString("nombresPropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getInt("numeroMegasGB"),
                        rs.getDouble("costoGB"));
                planmm.calcularPagoMensual();
                lista3.add(planmm);

            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanMinutosMegas");
            System.out.println(e.getMessage());

        }
        return lista3;
    }

    public void insertarPlanMinutosMegasEc(PlanPostPagoMinutosMegasEconomico planmme) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();

            String data = String.format("INSERT INTO PlanPostPagoMinutosMegasEconomico "
                    + "(nombresPropietario,"
                    + "cedulaPropietario,ciudadPropietario,marcaCelular,"
                    + "modeloCelular,numeroCelular,minutos,"
                    + "costoMinuto,numeroMegasGB,"
                    + "costoGB,pDescuento,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s, %s)",
                    planmme.obtenerNombresPropietario(),
                    planmme.obtenerCedulaPropietario(),
                    planmme.obtenerCiudadPropietario(),
                    planmme.obtenerMarcaCelular(),
                    planmme.obtenerModeloCelular(),
                    planmme.obtenerNumeroCelular(),
                    planmme.obtenerMinutos(),
                    planmme.obtenerCostoMinuto(),
                    planmme.obtenerNumeroMegasGB(),
                    planmme.obtenerCostoGB(),
                    planmme.obtenerPDescuento(),
                    planmme.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutosMegasEconomico> obtenerDataPlanMinutosMegasEconomico() {
        ArrayList<PlanPostPagoMinutosMegasEconomico> lista4 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegasEconomico;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico planmme = new PlanPostPagoMinutosMegasEconomico(
                        rs.getString("nombresPropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudadPropietario"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getInt("numeroMegasGB"),
                        rs.getDouble("costoGB"), rs.getDouble("pDescuento") * 100);
                planmme.calcularPagoMensual();
                lista4.add(planmme);

            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return lista4;
    }
}
