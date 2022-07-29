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
            String url = "jdbc:sqlite:bd/PlanCelular.db";
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

    public void insertarPlanMinutos(PlanPostPagoMinutos c) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            c.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMinutos "
                    + "(nombrePropietario,"
                    + "cedulaPropietario,ciudad,marca,"
                    + "modelo,numero,minutosNacionales,"
                    + "costoMinutoNacional,minutosInternacionales,"
                    + "costoMinutoInternacional,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s)",
                    c.obtenerNombresPropietario(),
                    c.obtenerCedulaPropietario(),
                    c.obtenerCiudadPropietario(),
                    c.obtenerMarcaCelular(),
                    c.obtenerModeloCelular(),
                    c.obtenerNumeroCelular(),
                    c.obtenerMinutosNacionales(),
                    c.obtenerCostoMinutoNacional(),
                    c.obtenerMinutosInternacionales(),
                    c.obtenerCostoMinutoInternacional(),
                    c.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarPlanMegas(PlanPostPagoMegas c) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            c.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMegas "
                    + "(nombrePropietario,cedulaPropietario,ciudad,marca,"
                    + "modelo,numero,numeroMegasEnGB,costoDeGB,"
                    + "tarifaBase,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + " %s, %s)",
                    c.obtenerNombresPropietario(),
                    c.obtenerCedulaPropietario(),
                    c.obtenerCiudadPropietario(),
                    c.obtenerMarcaCelular(),
                    c.obtenerModeloCelular(),
                    c.obtenerNumeroCelular(),
                    c.obtenerNumeroMegasGB(),
                    c.obtenerCostoGB(),
                    c.obtenerTarifaBase(),
                    c.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarPlanMinutosMegas(PlanPostPagoMinutosMegas c) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            c.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegas "
                    + "(nombrePropietario,cedulaPropietario,ciudad,marca,"
                    + "modelo,numero,minutos,"
                    + "costoMinutos,megasGB,"
                    + "costoMegasGB,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s)",
                    c.obtenerNombresPropietario(),
                    c.obtenerCedulaPropietario(),
                    c.obtenerCiudadPropietario(),
                    c.obtenerMarcaCelular(),
                    c.obtenerModeloCelular(),
                    c.obtenerNumeroCelular(),
                    c.obtenerMinutos(),
                    c.obtenerCostoMinuto(),
                    c.obtenerNumeroMegasGB(),
                    c.obtenerCostoGB(),
                    c.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public void insertarEconomicoPlanMinutosMegas(PlanPostPagoMinutosMegasEconomico c) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            c.calcularPagoMensual();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegasEconomico "
                    + "(nombrePropietario,"
                    + "cedulaPropietario,ciudad,marca,"
                    + "modelo,numero,minutos,"
                    + "costoMinutos,megasGB,"
                    + "costoGB,porcentajeDescuento,pagoMensual) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', %d, %s,"
                    + "%d, %s, %s, %s)",
                    c.obtenerNombresPropietario(),
                    c.obtenerCedulaPropietario(),
                    c.obtenerCiudadPropietario(),
                    c.obtenerMarcaCelular(),
                    c.obtenerModeloCelular(),
                    c.obtenerNumeroCelular(),
                    c.obtenerMinutos(),
                    c.obtenerCostoMinuto(),
                    c.obtenerNumeroMegasGB(),
                    c.obtenerCostoGB(),
                    c.obtenerPDescuento(),
                    c.obtenerPagoMensual());
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanPostPagoMinutos> obtenerPlanMinutos() {
        ArrayList<PlanPostPagoMinutos> lista1 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos planm = new PlanPostPagoMinutos(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
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

    public ArrayList<PlanPostPagoMegas> obtenerPlanMegas() {
        ArrayList<PlanPostPagoMegas> lista2 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMegas planme = new PlanPostPagoMegas(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getInt("numeroMegasEnGB"),
                        rs.getDouble("costoDeGB"),
                        rs.getDouble("tarifaBase"));
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

    public ArrayList<PlanPostPagoMinutosMegas> obtenerPlanMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegas> lista3 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegas planmm = new PlanPostPagoMinutosMegas(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinutos"),
                        rs.getInt("megasGB"),
                        rs.getDouble("costoMegasGB"));
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

    public ArrayList<PlanPostPagoMinutosMegasEconomico> obtenerPlanEconomicoMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegasEconomico> lista4 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegasEconomico;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico planPagomme = new PlanPostPagoMinutosMegasEconomico(
                        rs.getString("nombrePropietario"),
                        rs.getString("cedulaPropietario"),
                        rs.getString("ciudad"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("numero"),
                        rs.getInt("minutos"),
                        rs.getDouble("costoMinutos"),
                        rs.getInt("megasGB"),
                        rs.getDouble("costoGB"), rs.getDouble("porcentajeDescuento"));
                planPagomme.calcularPagoMensual();
                lista4.add(planPagomme);

            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return lista4;
    }
}
