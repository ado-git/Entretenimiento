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
public class POperatorResta extends P_Operator_Binary
{
    public POperatorResta()
    {
        super(0);
    }
    @Override
    public P_Expresion createExpresion(P_Expresion izq, P_Expresion der)
    {
        return new PExpresionResta(izq, der);
    }
}