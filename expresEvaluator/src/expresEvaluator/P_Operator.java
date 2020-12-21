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
public abstract class P_Operator
{
    protected int prioridad;
    
    private P_Operator(){}
    protected P_Operator(int prioridad)
    {
        this.prioridad = prioridad;
    }
    public int getPrioridad()
    {
        return this.prioridad;
    }
}
