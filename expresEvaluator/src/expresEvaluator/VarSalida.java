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
public class VarSalida
{
    protected String var_name = null;
    protected double val;
    protected boolean isCalculated = false;
    protected P_Expresion exp = null;
    
    public VarSalida(String var_name, P_Expresion exp)
    {
        this.var_name = var_name;
        this.exp = exp;
    }
    
    public double getValue() throws Exception
    {
        if(isCalculated)
            return val;
        else
        {
            val = exp.calcular();
            isCalculated = true;            
        }
        
        return val;
    }
    
    public void printCalcSteps() throws Exception
    {
        throw new Exception("not implemented");
    }
}
