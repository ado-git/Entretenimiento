/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.main;

import java.util.ArrayList;
import java.util.HashSet;
import juegopokemon.datos.Jugador;
import juegopokemon.datos.Pokemon;
import juegopokemon.datos.pokemones.Altaria;
import juegopokemon.datos.pokemones.MegaG;
import juegopokemon.datos.pokemones.Mewtwo;
import juegopokemon.datos.pokemones.Pikachu;
import juegopokemon.datos.pokemones.Swampert;
import juegopokemon.main.gestion_accion.GestoraDeAccion;
import juegopokemon.main.gestion_accion.GestoraDeAccionAbajo;
import juegopokemon.main.gestion_accion.GestoraDeAccionArriba;
import juegopokemon.main.gestion_accion.GestoraDeAccionDerecha;
import juegopokemon.main.gestion_accion.GestoraDeAccionIzquierda;
import juegopokemon.mapa.ElementoCasilla;
import juegopokemon.mapa.Mapa;
import utiles.EntradaSalida;

/**
 *
 * @author ado
 */
public class Juego {
    
    private Jugador jugador;
    private Mapa mapa;
    private final HashSet<Character> setDirecciones = new HashSet<>();
    private GestoraDeAccion gestoraAccionArriba;
    private GestoraDeAccion gestoraAccionAbajo;
    private GestoraDeAccion gestoraAccionDerecha;
    private GestoraDeAccion gestoraAccionIzquierda;

    public Juego(){
        setDirecciones.add("a".charAt(0));
        setDirecciones.add("b".charAt(0));
        setDirecciones.add("d".charAt(0));
        setDirecciones.add("i".charAt(0));
    }
    
    private void inicializarGestoresDeAccion(Jugador jugador, Mapa mapa)
    {
        gestoraAccionArriba = new GestoraDeAccionArriba(jugador, mapa);
        gestoraAccionAbajo = new GestoraDeAccionAbajo(jugador, mapa);
        gestoraAccionDerecha = new GestoraDeAccionDerecha(jugador, mapa);
        gestoraAccionIzquierda = new GestoraDeAccionIzquierda(jugador, mapa);
    }
    public void start()
    {
        System.out.println("------------------------");
        System.out.println("Este el juego de Pokemon");
        System.out.println("------------------------");
        System.out.println("");
        
        jugador = solicitarNombreJugador();
        
        ArrayList<Pokemon> arr = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            arr.add(new Pikachu(null));
            arr.add(new Altaria(null));
            arr.add(new MegaG(null));
            arr.add(new Mewtwo(null));
            arr.add(new Swampert(null));
        }
        
        mapa = new Mapa(arr, jugador);
        
        inicializarGestoresDeAccion(jugador, mapa);
        
        solicitarVerIntroduccion();
        
        while(true)
        {
            printMapaJugador();
            printMapaArray();
            atenderAlUsuario();
        }
    }
    private Jugador solicitarNombreJugador()
    {
        System.out.println("Introdusca su nombre:");
        
        String n = EntradaSalida.obtenerString();
        
        Jugador j = new Jugador(n, null);
        
        return j;
    } 
    
    private void solicitarVerIntroduccion()
    {
        System.out.println("Hola "+ jugador.getNombre());
        System.out.println("");
        System.out.println("Estas son las instrucciones:");
        System.out.println("Debe tratar de encontrar los pokemones, atacarlos y capturalos");
        
        EntradaSalida.solicitarEnterParaContinuar();
    }
    private void printMatriz(ElementoCasilla[][] matriz)
    {
        String s = "|";
        
        for (int indexFila = 0; indexFila < matriz.length; indexFila++) {
            for (int indexCol = 0; indexCol < matriz.length; indexCol++) {
                
                if(null == matriz[indexFila][indexCol]) 
                    s += " |";
                else switch (matriz[indexFila][indexCol].getTipoElemento()) {
                    case JUGADOR:
                        s += "X|";
                        break;
                    case POKEMON:
                        s += "P|";
                        break;
                  case POKEMON_ATRAPADO:
                        s += "A|";
                        break;
                    case RUNA:
                        s += "$|";
                        break;
                    default:
                        s += " |";
                        break;
                }
            }
            s+= "\n";
            if(indexFila < matriz.length - 1)
                s+="|";
        }
        
        System.out.println(s);        
    }
    private void printMapaArray()
    {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Mapa interno -para debugueo- los $ son las runas, los P los pokemones, los A los atrapados");
        System.out.println("------------------------------------------------------------------------------------------");
        
        printMatriz(mapa.getMatriz());
    }
    private void printMapaJugador()
    {
        System.out.println("-----------------");
        System.out.println("Mapa del jugador:");
        System.out.println("-----------------");
        
        ElementoCasilla[][] matriz = new ElementoCasilla[50][50];
        
        for(Pokemon pok : jugador.getPokemonesEncontrados())
        {
            matriz[pok.getPos().fila][pok.getPos().col] = pok;
        }
        
        matriz[jugador.getPosicion().fila][jugador.getPosicion().col] = jugador;
        
        printMatriz(matriz);
    }
    
    private void atenderAlUsuario()
    {   
        System.out.println("Entre direccion:");
        System.out.println("");
        System.out.println("a - arriba");
        System.out.println("b - abajo");
        System.out.println("d - derecha");
        System.out.println("i - izquierda");
        
        char c = EntradaSalida.obtenerChar(setDirecciones, true);
        
        /**
         * Aqui empiezan los problemas, se hizo una jerarquia de clases tan solo para poder gestionar un conjunto de metodos
         * que eran simples especializaciones de uno solo.
         * Aqui con un solo metodo general que tomara como parametro la direccion, se resolvia el problema
         * 
         * Conclusion: siempre generalizar los metodos tanto como se pueda y las especializaciones que sean solo para añadir
         * comodidad extra.
         */
        
        switch (c) {
            case 'a':
                gestoraAccionArriba.gestionarAccion();
                break;
            case 'b':
                gestoraAccionAbajo.gestionarAccion();
                break;
            case 'd':
                gestoraAccionDerecha.gestionarAccion();
                break;
            case 'i':
                gestoraAccionIzquierda.gestionarAccion();
                break;
            default:
                throw new AssertionError();
        }
    }
}
