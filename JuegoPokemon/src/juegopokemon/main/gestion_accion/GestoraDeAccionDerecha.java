/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.main.gestion_accion;

import juegopokemon.datos.Pos;
import juegopokemon.datos.Jugador;
import juegopokemon.datos.Pokemon;
import juegopokemon.mapa.Mapa;
import juegopokemon.mapa.TipoElemento;

/**
 *
 * @author ado
 */
public class GestoraDeAccionDerecha extends GestoraDeAccion{

    public GestoraDeAccionDerecha(Jugador jugador, Mapa mapa) {
        super(jugador, mapa);
    }

    @Override
    protected TipoElemento queHay(Pos p) {
        return mapa.queHayDerecha(jugador.getPosicion());
    }

    @Override
    protected void moverJugador() {
        mapa.moverJugadorDerecha();
    }

    @Override
    protected Pokemon obtenerRefPokemon() {
        return mapa.obtenerRefPokemonDerecha(jugador.getPosicion());
    }

    @Override
    protected void obtenerRuna() {
        mapa.obtenerRunaDerecha(jugador.getPosicion());
    }
}
