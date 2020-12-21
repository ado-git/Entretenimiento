/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.Stack;

/**
 *
 * @author ado
 */
public class ExpresionTree
{
    protected Stack<P_Operator> operatorStack = new Stack<>();
    protected Stack<P_Expresion> expresionStack = new Stack<>();
    
    private P_Expresion resolverOperacion(P_Operator op) throws Exception
    {
        if(op instanceof P_Operator_Binary)
        {
            P_Expresion der = expresionStack.pop();
            P_Expresion izq = expresionStack.pop();
            
            return ((P_Operator_Binary)op).createExpresion(izq, der);
        }
        else if(op instanceof P_Operator_Unary)
        {
            return ((P_Operator_Unary)op).createExpresion(expresionStack.pop());
        }
        
        throw new Exception("operator type not recognized");
    }
    public void pushOperador(P_Operator newOp) throws Exception
    {
        while(operatorStack.size() > 0 && newOp.getPrioridad() <= operatorStack.peek().getPrioridad())
        {
            expresionStack.push(resolverOperacion( operatorStack.pop() ) );
        }

        operatorStack.push(newOp);

    }
    public void pushExpresion(P_Expresion exp)
    {
        expresionStack.push(exp);
    }
    public void calcularPila() throws Exception
    {
        //aqui se calcula lo que queda en la pila.
        while(operatorStack.size() > 0)
        {
            expresionStack.push(resolverOperacion(operatorStack.pop()));
        }

        if(expresionStack.size() > 1)
            throw new Exception("inconsistencia en cantidad de expresiones en la pila");
    }
    public P_Expresion popUltimaExpresion()
    {
        return expresionStack.pop();
    }
    public int getTotalOperadores()
    {
        return operatorStack.size();
    }
    public int getTotalExpresiones()
    {
        return expresionStack.size();
    }
}
