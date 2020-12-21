/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.HashSet;


/**
 *
 * @author ado
 */
public class EntradaSalida
{
    private EntradaSalida(){}
    
    /**
     * Insiste en obtener un entero valido en un rango entre min y max.
     * @param min valor minimo del rango
     * @param max valor maximo del rango
     * @return el entero obtenido
     */

    public static int obtenerInt(int min, int max)
    {
        ScannerWrapper io = ScannerWrapper.getInstance();
        int n = 0;
        
        while(true)
        {
            try {
                n = io.nextInt();

                if(!Validaciones.isEnRango(n, min, max))
                    throw new Exception("numero incorrecto");
                break;
                
            } catch (Exception e) {
                System.out.println("Entrada invalida, intentelo nuevamente, " + e.getMessage());
            }
            
        }
        
        return n;
    }
    /**
     * Insiste en obtener un caracter y solo un caracter
     * @param a Set de caracteres de validacion
     * @param convertLowerCase especifica si hay hay que convertir a lowercase el caracter para que pueda ser encontrado en el Set
     * @return el caracter obtenido
     */
    public static char obtenerChar(HashSet<Character> a, boolean convertLowerCase)
    {
        ScannerWrapper io = ScannerWrapper.getInstance();
        char c = 0;
        
        while(true)
        {
            try {
                c = io.nextChar();
                
                if(!Validaciones.isInSet(c, a, convertLowerCase))
                    throw new Exception("Caracter invalido");

                break;
                
            } catch (Exception e) {
                System.out.println("Entrada invalida, intentelo nuevamente, " + e.getMessage());
            }
            
        }
        
        return c;
    }
    
    /**
     * obtiene un String de 1 o mas caracteres
     * @return el String obtenido
     */    
    public static String obtenerString()
    {
        return ScannerWrapper.getInstance().nextString();
    }
    /**
     * obtiene un si o un no como respuesta
     * @return true si es si, false si es otra respuesta o solo ENTER
     */    
    public static boolean obtenerSioNO()
    {
        return !ScannerWrapper.getInstance().nextLine().equalsIgnoreCase("N");
    }
    /**
     * obliga al usuario a presionar enter
     */    
    public static void obtenerEnter()
    {
        ScannerWrapper.getInstance().nextEnter();
    }
    /**
     * notifica y obliga al usuario a presionar enter
     */
    public static void solicitarEnterParaContinuar()
    {
        System.out.println("Presione Enter para continuar");
        
        EntradaSalida.obtenerEnter();
    }
    /**
     * notifica y obliga al usuario a presionar s para si o enter para no
     * @param pregunta La pregunta que se le desea hacer al usuario, sin los signos ¿?
     * @return true si es SI, false si es otra respuesta o solo se presiona enter
     */    
    public static boolean solicitarSioNo(String pregunta)
    {
        System.out.println("¿" + pregunta + "? ENTER para Si o n para no");
        
        return EntradaSalida.obtenerSioNO();
    }
}
