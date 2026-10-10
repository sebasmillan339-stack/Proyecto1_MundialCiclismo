/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Competidor extends Atleta {
    private int rankingMundial;
    private double estatura;
    private double peso;
    private int puntos;

    public Competidor(String nombre, int edad, String pais,
                      int rankingMundial, double estatura, double peso) {
        super(nombre, edad, pais);
        this.rankingMundial = rankingMundial;
        this.estatura = estatura;
        this.peso = peso;
        this.puntos = 0;
    }

    public int getRankingMundial() { return rankingMundial; }
    public double getEstatura() { return estatura; }
    public double getPeso() { return peso; }
    public int getPuntos() { return puntos; }

    public String obtenerDatos() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString() + " | Ranking: " + rankingMundial
                + " | Estatura: " + estatura + " m | Peso: " + peso
                + " kg | Puntos: " + puntos;
    }
}

    public void actualizarRanking(int puntosObtenidos) {
        puntos += puntosObtenidos;
        rankingMundial = Math.max(1, rankingMundial - puntosObtenidos / 10);
    }
    public void actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        int bonificacion = 0;
        if (ganoMedalla) {
            if (puntosObtenidos >= 100) {
                bonificacion = 50;
            } else {
                bonificacion = 20;
            }
        } else {
            if (puntosObtenidos >= 100) {
                bonificacion = 10;
            }
        }
        actualizarRanking(puntosObtenidos + bonificacion);
    }