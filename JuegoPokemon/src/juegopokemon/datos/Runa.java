/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon.datos;

import juegopokemon.mapa.ElementoCasilla;
import juegopokemon.mapa.TipoElemento;

/**
 *
 * @author ado
 */
public class Runa implements ElementoCasilla{

    @Override
    public TipoElemento getTipoElemento() {
        return TipoElemento.RUNA;
    }
}
