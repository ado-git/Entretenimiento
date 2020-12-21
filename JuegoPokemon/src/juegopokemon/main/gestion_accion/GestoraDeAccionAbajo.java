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
public class GestoraDeAccionAbajo extends GestoraDeAccion{

    public GestoraDeAccionAbajo(Jugador jugador, Mapa mapa) {
        super(jugador, mapa);
    }

    @Override
    protected TipoElemento queHay(Pos p) {
        return mapa.queHayAbajo(jugador.getPosicion());
    }

    @Override
    protected void moverJugador() {
        mapa.moverJugadorAbajo();
    }

    @Override
    protected Pokemon obtenerRefPokemon() {
        return mapa.obtenerRefPokemonAbajo(jugador.getPosicion());
    }

    @Override
    protected void obtenerRuna() {
        mapa.obtenerRunaAbajo(jugador.getPosicion());
    }
}
