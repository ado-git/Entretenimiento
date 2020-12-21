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
public class GestoraDeAccionIzquierda extends GestoraDeAccion{

    public GestoraDeAccionIzquierda(Jugador jugador, Mapa mapa) {
        super(jugador, mapa);
    }

    @Override
    protected TipoElemento queHay(Pos p) {
        return mapa.queHayIzq(jugador.getPosicion());
    }

    @Override
    protected void moverJugador() {
        mapa.moverJugadorIzquierda();
    }

    @Override
    protected Pokemon obtenerRefPokemon() {
        return mapa.obtenerRefPokemonIzq(jugador.getPosicion());
    }

    @Override
    protected void obtenerRuna() {
        mapa.obtenerRunaIzq(jugador.getPosicion());
    }
}
