/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.mapa;

import juegopokemon.datos.Pos;
import java.util.ArrayList;
import juegopokemon.datos.Jugador;
import juegopokemon.datos.Pokemon;
import juegopokemon.datos.Runa;

/**
 *
 * @author ado
 */
public class Mapa {
    private final ElementoCasilla[][] matriz = new ElementoCasilla[50][50];
    private final ArrayList<Pokemon> pokemones;
    private final Jugador jugador;

    public Mapa(ArrayList<Pokemon> pokemones, Jugador jugador) {
        this.pokemones = pokemones;
        this.jugador = jugador;
        
        inicializarMapaYPosiciones();
    }
    
    private ArrayList<Pos> getPosicionesMatriz()
    {
        ArrayList<Pos> arr = new ArrayList<>();
        
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz.length; col++) {
                arr.add( new Pos(fila, col));
            }
        }
        
        return arr;
    }
    private int getRandomArrayIndex(ArrayList<Pos> a)
    {
        return (int)(Math.random() * (a.size() - 1));
    }
    /**
     * Este metodo ubica aleatoreamente al jugador, los pokemones y las runas
     */
    private void inicializarMapaYPosiciones()
    {
        ArrayList<Pos> arrPosiciones = getPosicionesMatriz();
        
        int index = getRandomArrayIndex(arrPosiciones);
        Pos pJugador = arrPosiciones.get(index);
        jugador.setPosicion(pJugador);
        OperacionesEnMatriz.set(pJugador, jugador, matriz);
        arrPosiciones.remove(index);
        
        for(Pokemon p : pokemones)
        {
            index = getRandomArrayIndex(arrPosiciones);
            Pos pPokemon = arrPosiciones.get(index);
            p.setPos(pPokemon);
            OperacionesEnMatriz.set(pPokemon, p, matriz);
            arrPosiciones.remove(index);
        }
        
        for (int i = 0; i < 20; i++) {
            index = getRandomArrayIndex(arrPosiciones);
            Pos pRuna = arrPosiciones.get(index);
            OperacionesEnMatriz.set(pRuna, new Runa(), matriz);
            arrPosiciones.remove(index);
        }
    }
    
    /**
     * Esta debe ejecutarse justo antes de cada movida del jugador
     */
    private void moverPokemonesEscapando()
    {
        for(Pokemon p : pokemones)
        {
            if(p.isEscapando() && !p.isAtrapado())
            {
                int velocidad = (int)(Math.round(p.getVelocidad()));
                
                for (int i = 0; i < velocidad; i++) {
                    Pos nuevaPos = OperacionesEnMatriz.obtenerPosicionContiguaRandom(p.getPos(), matriz);

                    OperacionesEnMatriz.mover(p.getPos(), nuevaPos, matriz);
                    p.setPos(nuevaPos);
                }
            }
        }
    }
    /**
     * Este deberia haber sido el metodo disponible
     */
    public TipoElemento queHay(Direccion dir, Pos s)
    {
        moverPokemonesEscapando();

        return OperacionesEnMatriz.queHayContiguo(dir, s, matriz);
    }
    
    //estos siempre se usan para iniciar un movimiento asi que aqui se activa lo de mover a los pokemones
    public TipoElemento queHayDerecha(Pos s)
    {
        moverPokemonesEscapando();

        return OperacionesEnMatriz.queHayDerecha(s, matriz);
    }
    public TipoElemento queHayIzq(Pos s)
    {
        moverPokemonesEscapando();

        return OperacionesEnMatriz.queHayIzq(s, matriz);
    }
    public TipoElemento queHayArriba(Pos s)
    {
        moverPokemonesEscapando();
        
        return OperacionesEnMatriz.queHayArriba(s, matriz);
    }
    public TipoElemento queHayAbajo(Pos s)
    {
        moverPokemonesEscapando();
        
        return OperacionesEnMatriz.queHayAbajo(s, matriz);
    }

    /**
     * Este deberia haber sido el metdo disponible
     */
    public void obtenerRuna(Direccion dir, Pos s)
    {
        OperacionesEnMatriz.obtenerRunaContigua(dir, s, matriz);
        
        Pos newPos = OperacionesEnMatriz.obtenerPosicionContigua(dir, s);
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    
    //estos implican que el jugador se mueve a esa posicion
    public void obtenerRunaDerecha(Pos s)
    {
        OperacionesEnMatriz.obtenerRunaDerecha(s, matriz);
        
        Pos newPos = OperacionesEnMatriz.obtenerPosicionDerecha(s);
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void obtenerRunaIzq(Pos s)
    {        
        OperacionesEnMatriz.obtenerRunaIzq(s, matriz);
        
        Pos newPos = OperacionesEnMatriz.obtenerPosicionIzq(s);
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void obtenerRunaArriba(Pos s)
    {   
        OperacionesEnMatriz.obtenerRunaArriba(s, matriz);
        
        Pos newPos = OperacionesEnMatriz.obtenerPosicionArriba(s);
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void obtenerRunaAbajo(Pos s)
    {   
        OperacionesEnMatriz.obtenerRunaAbajo(s, matriz);
        
        Pos newPos = OperacionesEnMatriz.obtenerPosicionAbajo(s);
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    /**
     * Este deberia haber sido el metodo disponible
     */
    public Pokemon obtenerRefPokemon(Direccion dir, Pos s)
    {
        Pos p = OperacionesEnMatriz.obtenerPosicionContigua(dir, s);
        
        return (Pokemon)matriz[p.fila][p.col];
    }
    
    public Pokemon obtenerRefPokemonDerecha(Pos s)
    {
        Pos p = OperacionesEnMatriz.obtenerPosicionDerecha(s);
        
        return (Pokemon)matriz[p.fila][p.col];
    }
    public Pokemon obtenerRefPokemonIzq(Pos s)
    {
        Pos p = OperacionesEnMatriz.obtenerPosicionIzq(s);
        
        return (Pokemon)matriz[p.fila][p.col];
    }
    public Pokemon obtenerRefPokemonArriba(Pos s)
    {
        Pos p = OperacionesEnMatriz.obtenerPosicionArriba(s);
        
        return (Pokemon)matriz[p.fila][p.col];

    }
    public Pokemon obtenerRefPokemonAbajo(Pos s)
    {
        Pos p = OperacionesEnMatriz.obtenerPosicionAbajo(s);
        
        return (Pokemon)matriz[p.fila][p.col];

    }
    /**
     * Este deberia haber sido el metodo disponible
     */
    public void moverJugador(Direccion dir)
    {
        Pos newPos = OperacionesEnMatriz.obtenerPosicionContigua(dir, jugador.getPosicion());
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    
    public void moverJugadorDerecha()
    {
        Pos newPos = OperacionesEnMatriz.obtenerPosicionDerecha(jugador.getPosicion());
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void moverJugadorIzquierda()
    {   
        Pos newPos = OperacionesEnMatriz.obtenerPosicionIzq(jugador.getPosicion());
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void moverJugadorArriba()
    {
        Pos newPos = OperacionesEnMatriz.obtenerPosicionArriba(jugador.getPosicion());
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }
    public void moverJugadorAbajo()
    {   
        Pos newPos = OperacionesEnMatriz.obtenerPosicionAbajo(jugador.getPosicion());
        
        OperacionesEnMatriz.mover(jugador.getPosicion(), newPos, matriz);
        
        jugador.setPosicion(newPos);
    }

    public ElementoCasilla[][] getMatriz() {
        return matriz;
    }
}
