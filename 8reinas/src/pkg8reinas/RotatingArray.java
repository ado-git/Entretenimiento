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
public class RotatingArray {
    
    protected int[][] arr = null;
    protected int angulo = 0;
    protected boolean isFlipped = false;
    
    public static void main(String[] args)
    {
        RotatingArray a = new RotatingArray(4);
        
        a.fillArray();
        
        a.flip();
        
        a.rotate90();
        System.out.println(a);
        a.rotate90();
        System.out.println(a);
        a.rotate90();
        System.out.println(a);
        a.rotate90();
        System.out.println(a);
        
        
        
    }
    public RotatingArray(int size)
    {
        arr = new int[size][size];
    }
    public void fillArray()
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i > j)
                    arr[j][i] = 0;
                else if(i < j)
                    arr[j][i] = 1;
                else
                    arr[i][i] = i + 2;
            }
        }
    }
    @Override
    public String toString()
    {
        String s = "|";
        
        for (int indexCol = 0; indexCol < arr.length; indexCol++) {
            for (int indexFila = 0; indexFila < arr.length; indexFila++) {
                
                  s += getItem(indexCol, indexFila) + "|";
            }
            s+= "\n";
            if(indexCol < arr.length - 1)
                s+="|";
        }
        
        return s;
    }
    
    public void flip()
    {
        isFlipped = !isFlipped;
    }
    public void resetFlip()
    {
        isFlipped = false;
    }
    public void rotate90()
    {
        angulo = (angulo + 90) % 360;
    }
    public void resetRotate()
    {
        angulo = 0;
    }
    
    public int getItem(int indexCol, int indexFila)
    {
        int iCol = getFlipIndexCol(indexCol, indexFila);
        int iFila =  getFlipIndexFila(indexCol, indexFila);

        return arr[getNewIndexCol(iCol, iFila)][getNewIndexFila(iCol, iFila)];
    }
    
    protected int getFlipIndexCol(int indexCol, int indexFila)
    {
        if(isFlipped)
        {
            return indexFila;
        }
        else
        {
            return indexCol;
        }
    }
    protected int getFlipIndexFila(int indexCol, int indexFila)
    {
        if(isFlipped)
        {
            return indexCol;
        }
        else
        {
            return indexFila;
        }
    }
    
    protected int getNewIndexCol(int indexCol, int indexFila)
    {   
        switch (angulo) {
            case 0:                
                return indexCol;
            case 90:                
                return arr.length - 1 - indexFila;
            case 180:
                return arr.length - 1 - indexCol;
            case 270:                
                return indexFila;
            default:
                throw new AssertionError();
        }
    }
    protected int getNewIndexFila(int indexCol, int indexFila)
    {   
        switch (angulo) {
            case 0:                
                return indexFila;
            case 90:                
                return indexCol;
            case 180:
                return arr.length - 1 - indexFila;
            case 270:                
                return arr.length - 1 - indexCol;
            default:
                throw new AssertionError();
        }
    }
    
}
