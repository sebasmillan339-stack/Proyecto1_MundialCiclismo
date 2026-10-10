/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controlador.ControladorMundial;
import vista.VistaMundial;

public class Main {
    public static void main(String[] args) {
        ControladorMundial controlador = new ControladorMundial("Mundial de Ciclismo de Pista - Cali");
        VistaMundial vista = new VistaMundial(controlador);
        vista.iniciar();
    }
}