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
public abstract class Parser_Token
{
    public String token;
    
    public Parser_Token(String token)
    {
        this.token = token;
    }
    
    public String ToString()
    {
        return this.token;
    }
}
