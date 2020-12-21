/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author ado
 */
public class VariableHash
{
    HashMap<String, Double> hash = new HashMap<>();
    
    public void add(String varName, Double valor)
    {
        hash.put(varName, valor);
    }
    public boolean exists(String varName)
    {
        return hash.containsKey(varName);
    }
    public Double get(String varName)
    {
        return hash.get(varName);
    }
}
