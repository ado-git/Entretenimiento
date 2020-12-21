/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.*;


/**
 *
 * @author ado
 */
public class VarSalidaHash
{
    HashMap<String, VarSalida> hash = new HashMap<>();
    
    public void add(String varName, VarSalida valor) throws Exception
    {
        if(exists(varName))
            throw new Exception("variable " + varName + " ya existe");
        hash.put(varName, valor);
    }
    public boolean exists(String varName)
    {
        return hash.containsKey(varName);
    }
    public VarSalida get(String varName)
    {
        return hash.get(varName);
    }
    //esto es para poder iterar el hash
    public Set<Map.Entry<String, VarSalida>> getEntryset()
    {
        return hash.entrySet();
    }
    
}
