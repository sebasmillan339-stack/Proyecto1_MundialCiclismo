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
}