/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.Scanner;

/**
 *
 * @author ado
 */
public class ScannerWrapper
{
    private static final ScannerWrapper INSTANCE = new ScannerWrapper();
    private Scanner sc = new Scanner(System.in);
    
    private ScannerWrapper(){}
    
    public static ScannerWrapper getInstance()
    {
        return INSTANCE;
    }
    
    /**
     * obtiene un int desde la consola.
     * @return el entero obtenido
      @throws Exception si no es un entero
     */
    public int nextInt() throws Exception
    {
        int n = 0;
        
        try {
            n = sc.nextInt();
            sc.nextLine();

        } catch (Exception e) {
            sc = new Scanner(System.in);
            throw new Exception("No es un entero");
        }
    
        return n;
    }
    /**
     * obtiene un char desde la consola.
     * @return el char obtenido
      @throws Exception si no es solo un caracter
     */

    public char nextChar() throws Exception
    {
        char c = 0;
        
        String s = sc.next();
        sc.nextLine();

        if(s.length() > 1)
            throw new Exception("No se admite mas de un caracter");

        c = s.charAt(0);
    
        return c;
    }
    /**
     * hace que el usuario presione enter
     */
    public void nextEnter()
    {
        sc.nextLine();
    }
    /**
     * obtiene un string desde la consola de 1 o mas caracteres
     * @return el string
     */    
    public String nextString()
    {
        String s = sc.next();
        sc.nextLine();
        
        return s;
    }
    /**
     * obtiene un string desde la consola de 0 o mas caracteres
     * @return el string
     */
    public String nextLine()
    {
        return sc.nextLine();
    }
}
