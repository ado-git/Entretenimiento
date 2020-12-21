/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.mapa;

import juegopokemon.datos.Pos;

/**
 *
 * @author ado
 */
public class OperacionesEnMatriz {
    private OperacionesEnMatriz(){}

    /**
     * Metodo clave
     */
    private static Pos obtenerPosicionRelativa(Pos p, int incrementoFila, int incrementoCol)
    {
        return new Pos(p.fila + incrementoFila,p.col + incrementoCol);
    }
    
    public static boolean isPosicionDentroDeMatriz(Pos p, ElementoCasilla[][] matriz)
    {
        return !(p.fila < 0 || p.fila >= matriz.length || p.col < 0 || p.col >= matriz.length);
    }
    
    public static TipoElemento queHay(Pos p, ElementoCasilla[][] matriz)
    {
        if(!isPosicionDentroDeMatriz(p, matriz))
            return TipoElemento.BORDE;
        
        if(matriz[p.fila][p.col] == null)
            return TipoElemento.NADA;
        
        return matriz[p.fila][p.col].getTipoElemento();
    }
    /**
     * Este deberia ser el metodo usado para evitar la complejidad en las capas superiores
     * @param dir
     * @param p
     * @param matriz
     * @return 
     */
    public static TipoElemento queHayContiguo(Direccion dir ,Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionContigua(dir, p);
        
        return queHay(new Pos(newP.fila, newP.col), matriz);
    }
    
    public static TipoElemento queHayDerecha(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionDerecha(p);
        
        return queHay(new Pos(newP.fila, newP.col), matriz);
    }
    public static TipoElemento queHayIzq(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionIzq(p);
        
        return queHay(new Pos(newP.fila, newP.col), matriz);
    }
    
    public static TipoElemento queHayArriba(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionArriba(p);
        
        return queHay(new Pos(newP.fila, newP.col), matriz);
    }
    public static TipoElemento queHayAbajo(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionAbajo(p);
        
        return queHay(new Pos(newP.fila, newP.col), matriz);
    }
    /**
     * Este deberia ser el metodo usado
     * @param dir
     * @param p
     * @param matriz
     */
    public static void obtenerRunaContigua(Direccion dir, Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionContigua(dir, p);
        
        assert queHay(newP, matriz) == TipoElemento.RUNA;
       
        matriz[newP.fila][newP.col] = null;
    }
    
    public static void obtenerRunaDerecha(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionDerecha(p);
        
        assert queHay(newP, matriz) == TipoElemento.RUNA;
       
        matriz[newP.fila][newP.col] = null;
    }
    public static void obtenerRunaIzq(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionIzq(p);
        
        assert queHay(newP, matriz) == TipoElemento.RUNA;
       
        matriz[newP.fila][newP.col] = null;
    }
    
    public static void obtenerRunaArriba(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionArriba(p);
        
        assert queHay(newP, matriz) == TipoElemento.RUNA;
       
        matriz[newP.fila][newP.col] = null;
    }
    public static void obtenerRunaAbajo(Pos p, ElementoCasilla[][] matriz)
    {
        Pos newP = obtenerPosicionAbajo(p);
        
        assert queHay(newP, matriz) == TipoElemento.RUNA;
       
        matriz[newP.fila][newP.col] = null;
    }
    public static Pos obtenerPosicionContiguaRandom(Pos posicion, ElementoCasilla[][] matriz)
    {
        Pos newP;
        
        int i = (int)(Math.random() * 4);//uno mas para que tenga mas probabilidad el 3, en 4 se quedaria en el mismo lugar
        
        switch (i) {
            case 0:
                newP = obtenerPosicionArriba(posicion);
                
                if(OperacionesEnMatriz.queHay(newP, matriz) == TipoElemento.NADA)
                    return new Pos(newP.fila, newP.col);
                break;
            case 1:
                newP = obtenerPosicionAbajo(posicion);
                
                if(OperacionesEnMatriz.queHay(newP, matriz) == TipoElemento.NADA)
                    return new Pos(newP.fila, newP.col);
                break;                
            case 2:
                newP = obtenerPosicionDerecha(posicion);
                
                if(OperacionesEnMatriz.queHay(newP, matriz) == TipoElemento.NADA)
                    return new Pos(newP.fila, newP.col);
                break;                
            case 3:
                newP = obtenerPosicionIzq(posicion);
                
                if(OperacionesEnMatriz.queHay(newP, matriz) == TipoElemento.NADA)
                    return new Pos(newP.fila, newP.col);
                break;
        }
        
        return posicion;
    }
    /**
     * Este deberia ser el metodo usado para eliminar la complejidad en las capas superiores y en esta clase
     * @param p
     * @param dir La Arriba, abajo, izquierda o derecha
     * @return 
     */
    public static Pos obtenerPosicionContigua(Direccion dir, Pos p)
    {
        switch (dir) {
            case ARRIBA:
                return obtenerPosicionRelativa(p, -1, 0);
            case ABAJO:
                return obtenerPosicionRelativa(p, 1, 0);
            case DERECHA:
                return obtenerPosicionRelativa(p, 0, 1);
            case IZQUIERDA:
                return obtenerPosicionRelativa(p, 0, -1);
            default:
                throw new AssertionError();
        }
    }
    
    public static Pos obtenerPosicionDerecha(Pos p)
    {
        return new Pos(p.fila, p.col + 1);
    }
    public static Pos obtenerPosicionIzq(Pos p)
    {
        return new Pos(p.fila, p.col - 1);
    }
    public static Pos obtenerPosicionArriba(Pos p)
    {
        return new Pos(p.fila - 1, p.col);
    }
    public static Pos obtenerPosicionAbajo(Pos p)
    {
        return new Pos(p.fila + 1, p.col);
    }


    /**
     * 
     * @param p
     * @param matriz
     * @return retorna una referencia al elemento en la posicion p
     */
    public static ElementoCasilla get(Pos p, ElementoCasilla[][] matriz)
    {
        return matriz[p.fila][p.col];
    }
    public static void set(Pos p, ElementoCasilla e, ElementoCasilla[][] matriz)
    {
        assert matriz[p.fila][p.col] == null;
        
        matriz[p.fila][p.col] = e;
    }
    public static void eliminar(Pos p, ElementoCasilla[][] matriz)
    {
        matriz[p.fila][p.col] = null;
    }
    
    /**
     * Soporta moverse hacia la misma posicion
     * @param actual
     * @param nueva
     * @param matriz
     */
    public static void mover(Pos actual, Pos nueva, ElementoCasilla[][] matriz)
    {
        if(actual.fila == nueva.fila && actual.col == nueva.col)
            return;
        
        set(nueva, get(actual, matriz), matriz);
        eliminar(actual, matriz);
    }
}
