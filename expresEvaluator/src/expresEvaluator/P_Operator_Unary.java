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
public abstract class P_Operator_Unary extends P_Operator
{
    public P_Operator_Unary(int prioridad)
    {
        super(prioridad);
    }
    public abstract P_Expresion createExpresion(P_Expresion op);
}