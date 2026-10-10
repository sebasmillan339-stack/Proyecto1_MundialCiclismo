/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorMundial;
import java.util.Scanner;

public class VistaMundial {
    private ControladorMundial controlador;
    private Scanner sc = new Scanner(System.in);

    public VistaMundial(ControladorMundial controlador) {
        this.controlador = controlador;
    }

    public void iniciar() {
        int op;
        do {
            System.out.println("\n=== MUNDIAL DE CICLISMO DE PISTA - CALI ===");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar competidor");
            System.out.println("3. Actualizar ranking");
            System.out.println("4. Ver reporte");
            System.out.println("0. Salir");
            op = leerEntero("Opción: ");
            switch (op) {
                case 1: registrarEquipo(); break;
                case 2: registrarCompetidor(); break;
                case 3: actualizarRanking(); break;
                case 4: System.out.println("\n" + controlador.generarReporte()); break;
                case 0: System.out.println("Hasta pronto."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }

    private void registrarEquipo() {
        String nombre = leerTexto("Nombre del equipo: ");
        String pais = leerTexto("País: ");
        if (controlador.agregarEquipo(nombre, pais)) {
            System.out.println("Equipo registrado.");
        } else {
            System.out.println("Ya existe un equipo con ese nombre.");
        }
    }

    private void registrarCompetidor() {
        String equipo = leerTexto("Equipo al que pertenece: ");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String pais = leerTexto("País: ");
        int ranking = leerEntero("Ranking mundial: ");
        double estatura = leerDecimal("Estatura (m): ");
        double peso = leerDecimal("Peso (kg): ");
        if (controlador.agregarCompetidor(equipo, nombre, edad, pais, ranking, estatura, peso)) {
            System.out.println("Competidor registrado.");
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    private void actualizarRanking() {
        String nombre = leerTexto("Nombre del competidor: ");
        int puntos = leerEntero("Puntos obtenidos: ");
        String resp = leerTexto("¿Ganó medalla? (s/n): ");
        boolean medalla = resp.equalsIgnoreCase("s");
        if (controlador.actualizarRanking(nombre, puntos, medalla)) {
            System.out.println("Ranking actualizado: " + controlador.buscarCompetidor(nombre));
        } else {
            System.out.println("Competidor no encontrado.");
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}