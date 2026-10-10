/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controlador.ControladorMundial;
import modelo.Competidor;

public class PruebasMundial {
    static int fallos = 0;

    static void verificar(String nombre, boolean condicion) {
        System.out.println((condicion ? "OK     " : "FALLÓ  ") + nombre);
        if (!condicion) fallos++;
    }

    public static void main(String[] args) {
        // Unitarias
        Competidor c = new Competidor("Ana", 25, "Colombia", 20, 1.70, 62);
        c.actualizarRanking(50);
        verificar("actualizarRanking(50) suma puntos", c.getPuntos() == 50);
        verificar("actualizarRanking(50) mejora ranking", c.getRankingMundial() == 15);

        Competidor d = new Competidor("Luis", 27, "Chile", 30, 1.80, 75);
        d.actualizarRanking(100, true);   // 100 + bono 50 = 150
        verificar("medalla y >=100 da 150 puntos", d.getPuntos() == 150);

        Competidor e = new Competidor("Eva", 22, "Perú", 30, 1.65, 58);
        e.actualizarRanking(40, true);    // 40 + 20 = 60
        verificar("medalla y <100 da 60 puntos", e.getPuntos() == 60);

        verificar("toString incluye datos de Atleta", c.toString().contains("Colombia"));

        // Integración
        ControladorMundial ctrl = new ControladorMundial("Prueba");
        verificar("agregar equipo", ctrl.agregarEquipo("Equipo1", "Colombia"));
        verificar("no duplicar equipo", !ctrl.agregarEquipo("Equipo1", "Colombia"));
        verificar("agregar competidor", ctrl.agregarCompetidor("Equipo1", "Ana", 25, "Colombia", 20, 1.70, 62));
        verificar("competidor en equipo inexistente falla", !ctrl.agregarCompetidor("X", "Z", 20, "Y", 1, 1.7, 60));
        verificar("actualizar ranking vía controlador", ctrl.actualizarRanking("Ana", 80, true));
        verificar("reporte contiene a Ana", ctrl.generarReporte().contains("Ana"));

        System.out.println(fallos == 0 ? "\nTodas las pruebas pasaron." : "\nFallos: " + fallos);
    }
}