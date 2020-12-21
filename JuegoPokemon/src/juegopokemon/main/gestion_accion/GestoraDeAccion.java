/*
 * Esta clase es solo para resolver la sobrecomplicacion de diferenciar los metodos en hacia arriba, hacia abajo etc
 */
package juegopokemon.main.gestion_accion;

import juegopokemon.datos.Pos;
import juegopokemon.datos.Jugador;
import juegopokemon.datos.Pokemon;
import juegopokemon.mapa.Mapa;
import juegopokemon.mapa.TipoElemento;
import utiles.EntradaSalida;

/**
 *
 * @author ado
 */
public abstract class GestoraDeAccion {
    protected final Jugador jugador;
    protected final Mapa mapa;

    public GestoraDeAccion(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
    }
    
    public void gestionarAccion()
    {
        TipoElemento tE;
        
        tE = queHay(jugador.getPosicion());
        
        switch (tE) {
            case NADA:
                moverJugador();
                break;
            case POKEMON:
                Pokemon pok = obtenerRefPokemon();
                
                if(jugador.getPelotasRestantes() <= 0)
                {
                    System.out.println("No tiene pelotas suficientes para atacar al pokemon, debe encontrar una runa");
                    EntradaSalida.solicitarEnterParaContinuar();
                    break;
                }
                
                if(!jugador.pegar())
                {
                    System.out.println("Fallo al pegarle al pokemon, perdio una pelota");
                    EntradaSalida.solicitarEnterParaContinuar();
                    break;
                }
                
                pok.golpear();
                jugador.añadirPokemonEncontrado(pok);
                
                if(pok.isAtrapado())
                    System.out.println("Pokemon atrapado.");
                else
                    System.out.println("Pokemon golpeado.");
                
                System.out.println("Le quedan " + jugador.getPelotasRestantes() + " pelotas restantes");
                EntradaSalida.solicitarEnterParaContinuar();
                break;
            case RUNA:
                obtenerRuna();
                jugador.agregarPelotas(10);
                System.out.println("Runa encontrada, total de pelotas: " + jugador.getPelotasRestantes());
                EntradaSalida.solicitarEnterParaContinuar();
                break;
            default:
                System.out.println("No se pudo mover a esa posicion");
                EntradaSalida.solicitarEnterParaContinuar();
                break;
        }
    }
    protected abstract TipoElemento queHay(Pos p);
    protected abstract void moverJugador();
    protected abstract Pokemon obtenerRefPokemon();
    protected abstract void obtenerRuna();
}
