/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.datos;

import java.util.Collection;
import java.util.HashMap;
import juegopokemon.mapa.ElementoCasilla;
import juegopokemon.mapa.TipoElemento;

/**
 *
 * @author ado
 */
public class Jugador implements ElementoCasilla{
    private final String nombre;
    private final HashMap<String, Pokemon> hashPokemonesEncontrados = new HashMap<>();
    private int pelotasRestantes = 10;
    private Pos posicion;

    public Jugador(String nombre, Pos posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }
    
    private String generarKey(Pos p)
    {
        return "" + p.fila + "" + p.col;
    }
    public void añadirPokemonEncontrado(Pokemon p)
    {
        String key = generarKey(p.getPos());
        
        if(!hashPokemonesEncontrados.containsKey(key))
            hashPokemonesEncontrados.put(key, p);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPelotasRestantes() {
        return pelotasRestantes;
    }

    private void quitarPelota() {
        this.pelotasRestantes--;
    }

    public void agregarPelotas(int total) {
        this.pelotasRestantes +=total;
    }

    public Pos getPosicion() {
        return posicion;
    }

    public void setPosicion(Pos posicion) {
        this.posicion = posicion;
    }

    @Override
    public TipoElemento getTipoElemento() {
        return TipoElemento.JUGADOR;
    }

    public Collection<Pokemon> getPokemonesEncontrados() {
        return hashPokemonesEncontrados.values();
    }
    public boolean pegar()
    {
        quitarPelota();
        
        return Math.random() > 0.3;//70% probabilidad
    }
}
