/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.datos;

import juegopokemon.mapa.ElementoCasilla;
import juegopokemon.mapa.TipoElemento;

/**
 * Realmente no hacia falta hacer una jerarquia de pokemones porque solo se diferenciaban en el nombre, demasiado overhead.
 * @author ado
 */
public abstract class Pokemon implements ElementoCasilla{
    private final String nombre;
    private Pos pos;
    private final double velocidad = 1;
    private int defensa = 3;
    private boolean isEscapando = false;

    public Pokemon(String nombre, Pos pos) {
        this.nombre = nombre;
        this.pos = pos;
    }

    public String getNombre() {
        return nombre;
    }

    public Pos getPos() {
        return pos;
    }

    public double getVelocidad() {
        return velocidad + Math.random();
    }

    public int getDefensa() {
        return defensa;
    }

    public void golpear() {
        this.defensa--;
        
        isEscapando = true;
    }
    public boolean isAtrapado()
    {
        return defensa <= 1;
    }

    public boolean isEscapando() {
        return isEscapando;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    @Override
    public TipoElemento getTipoElemento() {
        if(!isAtrapado())
            return TipoElemento.POKEMON;
        
        return TipoElemento.POKEMON_ATRAPADO;
    }
    
}
