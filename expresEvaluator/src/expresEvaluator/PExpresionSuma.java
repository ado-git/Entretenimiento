/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

/**
 *
 * @author ado
 */
public class PExpresionSuma extends P_Expresion
{
    protected P_Expresion izq;
    protected P_Expresion der;
    
    private PExpresionSuma(){}
    public PExpresionSuma(P_Expresion izq, P_Expresion der)
    {
        this.izq = izq;
        this.der = der;
    }
    
    @Override
    public double calcular() throws Exception
    {
        return izq.calcular() + der.calcular();
    }
}
