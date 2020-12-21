/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ado
 */
public class EvaluadorDeExpresiones
{
    protected HashMap<String, Double> varEntradaHash = new HashMap<>();
    protected VarSalidaHash varsalidaHash = new VarSalidaHash();
    protected String input = null;
    
    private EvaluadorDeExpresiones(){}
    public EvaluadorDeExpresiones(String input)
    {
        this.input = input;
    }
    public void addVariableEntrada(String var_name, Double val)
    {
        varEntradaHash.put(var_name, val);
    }
    public Set<Map.Entry<String, VarSalida>> Eval() throws Exception
    {
        //separar entrada por ;
        String[] s = input.split(";");
        
        for(String instruccion: s)
        {   
            Parser p = EvaluadorExpresionesDeAsignacion.lexInput(instruccion);

            //se añaden las variables (rusticamente)
            for(Map.Entry<String, Double> e :  varEntradaHash.entrySet())
            {
                p.definirVariable(e.getKey(), e.getValue());
            }
            for(Map.Entry<String, VarSalida> e :  varsalidaHash.getEntryset())
            {
                p.definirVariable(e.getKey(), e.getValue().getValue());
            }              

            //parse
            P_Expresion exp = p.parse();

            //añade la nueva variable a las variables de salida
            varsalidaHash.add(p.getSalida(), new VarSalida(p.getSalida(), exp));
        }
        
        //esto es solo para resolver
        return this.varsalidaHash.getEntryset();
    }
}
