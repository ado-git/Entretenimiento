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
public class PExpresionNumero extends P_Expresion
{
    protected double numero;
    
    private PExpresionNumero(){}
    public PExpresionNumero(double numero)
    {
        this.numero = numero;
    }
     
    @Override
    public double calcular()
    {
        return numero;
    }
    
}
