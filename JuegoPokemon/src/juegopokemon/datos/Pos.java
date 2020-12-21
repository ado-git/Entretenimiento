/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.datos;

/**
 *
 * @author ado
 */
public class Pos {
    public final int fila;
    public final int col;

    private Pos() {
        fila = 0;
        col = 0;
    }

    public Pos(int fila, int col) {
        this.fila = fila;
        this.col = col;
    }
    
    
    
}
