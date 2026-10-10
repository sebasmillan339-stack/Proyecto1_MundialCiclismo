/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Competencia;
import modelo.Competidor;
import modelo.Equipo;

public class ControladorMundial {
    private Competencia competencia;

    public ControladorMundial(String nombreEvento) {
        this.competencia = new Competencia(nombreEvento);
    }

    public boolean agregarEquipo(String nombre, String pais) {
        if (competencia.buscarEquipo(nombre) != null) {
            return false;
        }
        competencia.agregarEquipo(new Equipo(nombre, pais));
        return true;
    }

    public boolean agregarCompetidor(String nombreEquipo, String nombre, int edad,
                                     String pais, int ranking, double estatura, double peso) {
        Equipo e = competencia.buscarEquipo(nombreEquipo);
        if (e == null) {
            return false;
        }
        e.agregarCompetidor(new Competidor(nombre, edad, pais, ranking, estatura, peso));
        return true;
    }

    public boolean actualizarRanking(String nombreCompetidor, int puntos, boolean medalla) {
        Competidor c = competencia.buscarCompetidor(nombreCompetidor);
        if (c == null) {
            return false;
        }
        c.actualizarRanking(puntos, medalla);
        return true;
    }

    public Competidor buscarCompetidor(String nombre) {
        return competencia.buscarCompetidor(nombre);
    }

    public String generarReporte() {
        return competencia.generarReporte();
    }
}