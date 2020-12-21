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
public class POperatorMenosUnario extends P_Operator_Unary
{
    public POperatorMenosUnario()
    {
        super(20);
    }
    @Override
    public P_Expresion createExpresion(P_Expresion op)
    {
        return new PExpresionMenosUnario(op);
    }
}