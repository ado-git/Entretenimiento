/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import java.util.HashMap;

/**
 *
 * @author ado
 */
public class ReinasMain {

    /**
     * @param args the command line arguments
     */
    static int counter = 0;
    static HashMap<String, Object> hmap = new HashMap<String, Object>();
    
    public static void main(String[] args) {
        run();
    }
    private static void run()
    {
        ReinasArrays rArrays = new ReinasArrays();
        
        recurse(0, rArrays);
        
        System.out.println("Total de resultados: " + counter);
        System.out.println("Soluciones únicas: " + hmap.size());
        
    }
    private static void recurse(final int fila, ReinasArrays rArrays)
    {
        if(fila > 7)
        {
            counter++;
            
            if(addSolution(rArrays.getColArray()))
                System.out.println(rArrays);
            
            return;
        }
        
        for (int col = 0; col < 8; col++) {
            
            if(isAvailable(col, fila, rArrays))
            {
                usePosition(col, fila, rArrays);
                
                recurse(fila + 1, rArrays);
                
                freePosition(col, fila, rArrays);
            }
            
        }
    }
    private static boolean isAvailable(int indexCol, int indexFila, ReinasArrays rArrays)
    {
        return rArrays.isEmptyCol(indexCol) && rArrays.isEmptyFila(indexFila) && rArrays.isEmptyDiag1(ReinasArrays.getIndexDiag1(indexCol, indexFila)) && rArrays.isEmptyDiag2(ReinasArrays.getIndexDiag2(indexCol, indexFila));
    }
    private static void usePosition(int indexCol, int indexFila, ReinasArrays rArrays)
    {
        rArrays.useCol(indexCol, indexFila);
        rArrays.useFila(indexFila, indexCol);
        rArrays.useDiag1(ReinasArrays.getIndexDiag1(indexCol, indexFila));
        rArrays.useDiag2(ReinasArrays.getIndexDiag2(indexCol, indexFila));
    }
    private static void freePosition(int indexCol, int indexFila, ReinasArrays rArrays)            
    {
        rArrays.freeCol(indexCol);
        rArrays.freeFila(indexFila);
        rArrays.freeDiag1(ReinasArrays.getIndexDiag1(indexCol, indexFila));
        rArrays.freeDiag2(ReinasArrays.getIndexDiag2(indexCol, indexFila));
    }
    
    private static boolean addSolution(int[] arrayCols)
    {
        ReinasRotatingArray rA =  new ReinasRotatingArray(arrayCols);
        
        for (int i = 0; i < 4; i++) {
            
            if(hmap.containsKey(rA.getHash()))
                return false;
            
            rA.rotate90();//la cuarta vez se rota por gusto, igual no importa
        }
        
        rA.flip();
        
        for (int i = 0; i < 4; i++) {
            
            if(hmap.containsKey(rA.getHash()))
                return false;
            
            rA.rotate90();
        }
        
        hmap.put(rA.getHash(), null);
        
        return true;
    }
}
