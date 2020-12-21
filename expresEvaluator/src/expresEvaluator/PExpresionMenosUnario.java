/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

/**
 * Esta clase es para cuando haya un operador unario, y no tener que calcular al momento de parsear. 
 * @author ado
 */
public class PExpresionMenosUnario extends P_Expresion
{
    protected P_Expresion exp;
    
    private PExpresionMenosUnario(){}
    public PExpresionMenosUnario(P_Expresion exp)
    {
        this.exp = exp;
    }
    @Override
    public double calcular() throws Exception
    {
        return -1 * exp.calcular();
    }
}
