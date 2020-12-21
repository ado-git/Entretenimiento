/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.ArrayList;

/**
 *
 * @author ado
 */
public class Parser
{
    protected Parser_Aritmetico pAritmetico = null;
    protected ArrayList<Parser_Token> pTokens = null;
    protected String salida;
    
    private Parser(){}
    public Parser(ArrayList<Parser_Token> pTokens) throws Exception
    {
        salida = getSalida(pTokens);
         
        pAritmetico = new Parser_Aritmetico(getParserAritmTokens(pTokens));
    }
    public P_Expresion parse() throws Exception
    {
        return pAritmetico.parse();
    }
    public void definirVariable(String varName, Double valor)
    {
        pAritmetico.definirVariable(varName, valor);
    }
    public String getSalida()
    {
        return salida;
    }
    
    private String getSalida(ArrayList<Parser_Token> pTokens) throws Exception
    {
        if( (pTokens.get(0) instanceof ParserVariable) && (pTokens.get(1) instanceof ParserAsignacion) )
        {
            return pTokens.get(0).token;
        }
        
        throw new Exception("no existe variable de salida");
    }
    private ArrayList<Parser_Token> getParserAritmTokens(ArrayList<Parser_Token> pTokens)
    {
        ArrayList<Parser_Token> t = new ArrayList<>();
        
        for(int i=2; i < pTokens.size(); i++)
        {
            t.add(pTokens.get(i));
        }
        
        return t;
    }
}
