/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

/**
 *
 * @author ado
 */
public class ReinasArrays {
    int[] col = new int[8];
    int[] fila = new int[8];
    int[] diag1 = new int[15];
    int[] diag2 = new int[15];
    
    public ReinasArrays()
    {
        initArray(col);
        initArray(fila);
        initArray(diag1);
        initArray(diag2);
    }
    private void initArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;            
        }
    }
    private void assertUpperlimit(int index)
    {   
        assert index < 8 : "se excedió el limite";
    }
    private void assertLowerlimit(int index)
    {
        assert index >= 0: "se fue por debajo del limite";
    }
    private void assertDiagUpperlimit(int index)
    {
        assert index < 15 : "se excedió el limite";
    }
    
    public void useCol(int index, int fila)
    {
        col[index] = fila;
        assertUpperlimit(index);
    }
    public void freeCol(int index)
    {
        col[index] = -1;
        assertLowerlimit(index);
    }    
    public void useFila(int index, int col)
    {
        fila[index] = col;
        assertUpperlimit(index);
    }
    public void freeFila(int index)
    {
        fila[index] = -1;
        assertLowerlimit(index);
    }    
    public void useDiag1(int index)
    {   
        diag1[index] = 1;
        assertDiagUpperlimit(index);
    }
    public void freeDiag1(int index)
    {   
        diag1[index] = -1;
        assertLowerlimit(index);
    }    
    public void useDiag2(int index)
    {
        diag2[index] = 1;
        assertDiagUpperlimit(index);
    }
    public void freeDiag2(int index)
    {
        diag2[index] = -1;
        assertLowerlimit(index);
    }
    
    public boolean isEmptyCol(int index)
    {
        return col[index] == -1;
    }
    public boolean isEmptyFila(int index)
    {
        return fila[index] == -1;
    }
    public boolean isEmptyDiag1(int index)
    {
        return diag1[index] == -1;
    }
    public boolean isEmptyDiag2(int index)
    {
        return diag2[index] == -1;
    }
    
    public int[] getColArray()
    {
        return col;
    }
    
    @Override
    public String toString()
    {
        String s = "|";
        
        for (int indexFila = 0; indexFila < 8; indexFila++) {
            for (int indexCol = 0; indexCol < 8; indexCol++) {
                if(col[indexCol] == indexFila)
                    s += "*|";
                else
                    s += " |";
            }
            s+= "\n";
            if(indexFila < 7)
                s+="|";
        }
        
        return s;
    }
    
    public static int getIndexDiag1(int indexCol, int indexFila)
    {
        return indexCol - indexFila + 7;
    }
    public static int getIndexDiag2(int indexCol, int indexFila)
    {
        return indexCol + indexFila;
    }
}
