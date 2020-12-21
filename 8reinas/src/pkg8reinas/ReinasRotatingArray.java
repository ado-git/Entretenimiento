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
public class ReinasRotatingArray
{
    protected int[] arrayCol;
    protected int angulo = 0;
    protected boolean isFlipped = false;

    public static void main(String[] args)
    {   
        int[] arr = {0,1,2,3,4,5,6,7};
        
        ReinasRotatingArray rArray = new ReinasRotatingArray(arr);
        
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        
        System.out.println("--------flipped-----");
        rArray.flip();
        System.out.println(rArray);
        System.out.println(rArray.getHash());

        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
        rArray.rotate90();
        System.out.println(rArray);
        System.out.println(rArray.getHash());
    }

    public ReinasRotatingArray(int[] col)
    {
        this.arrayCol = col;
    }
    private ReinasRotatingArray(){}
    
    @Override
    public String toString()
    {
        String s = "|";
        
        for (int indexCol = 0; indexCol < arrayCol.length; indexCol++) {
            for (int indexFila = 0; indexFila < arrayCol.length; indexFila++) {

                int iCol = getFlipIndexCol(indexCol, indexFila);
                int iFila =  getFlipIndexFila(indexCol, indexFila);

                if(arrayCol[getNewIndexCol(iCol, iFila)] == getNewIndexFila(iCol, iFila))
                    s += "*|";
                else
                    s += " |";
            }
            s+= "\n";
            if(indexCol < arrayCol.length - 1)
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
    public String getHash()
    {
        int[] tmpArray = new int[arrayCol.length];
        
        for (int indexCol = 0; indexCol < arrayCol.length; indexCol++) {
            
            int indexFila = arrayCol[indexCol];
            
            int iCol = getFlipIndexCol(indexCol, indexFila);
            int iFila =  getFlipIndexFila(indexCol, indexFila);

            tmpArray[getNewIndexCol(iCol, iFila)] = getNewIndexFila(iCol, iFila);
        }
        
        String s="";
        for (int i = 0; i < tmpArray.length; i++) {
            s += tmpArray[i] + ",";
            
        }
        
        return s;
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
                return arrayCol.length - 1 - indexFila;
            case 180:
                return arrayCol.length - 1 - indexCol;
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
                return arrayCol.length - 1 - indexFila;
            case 270:                
                return arrayCol.length - 1 - indexCol;
            default:
                throw new AssertionError();
        }
    }
}
