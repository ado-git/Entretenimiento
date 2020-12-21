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
public class PExpresionVariable extends P_Expresion
{
    protected String varName;
    protected VariableHash varHash;
    
    private PExpresionVariable(){}
    public PExpresionVariable(String varName, VariableHash varHash)
    {
        this.varName = varName;
        this.varHash = varHash;
    }
     
    @Override
    public double calcular() throws Exception
    {
        if(varHash.exists(varName))
            return varHash.get(varName);
        
        throw new Exception("variable no definida: " + varName);
    }
}
