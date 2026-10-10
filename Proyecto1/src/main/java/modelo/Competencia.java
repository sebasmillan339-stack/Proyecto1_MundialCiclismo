/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Competencia {
    private String nombreEvento;
    private List<Equipo> equipos;

    public Competencia(String nombreEvento) {
        this.nombreEvento = nombreEvento;
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo e) {
        equipos.add(e);
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public Competidor buscarCompetidor(String nombre) {
        for (Equipo e : equipos) {
            for (Competidor c : e.getCompetidores()) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
        }
        return null;
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(nombreEvento).append(" ===\n");
        if (equipos.isEmpty()) {
            sb.append("No hay equipos registrados.\n");
        }
        for (Equipo e : equipos) {
            sb.append(e.obtenerDatosEquipo());
        }
        return sb.toString();
    }
}