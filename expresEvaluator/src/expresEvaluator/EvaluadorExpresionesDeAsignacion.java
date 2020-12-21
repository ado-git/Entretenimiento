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
public class EvaluadorExpresionesDeAsignacion
{
    private EvaluadorExpresionesDeAsignacion(){}
    public static Parser lexInput(String s) throws Exception
    {
        Lexer l = new Lexer();
        
        return new Parser(l.parse(s));
    }
}
