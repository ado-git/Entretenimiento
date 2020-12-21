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
public class Parser_Aritmetico
{
    protected ArrayList<Parser_Token> pTokens;
    protected VariableHash varHash = null;
    protected ExpresionTreeGenerator expTreeGen = null;
    protected int index = 0;
    
    private Parser_Aritmetico(){}
    public Parser_Aritmetico(ArrayList<Parser_Token> pTokens)
    {
        this(pTokens, new VariableHash());
    }
    public Parser_Aritmetico(ArrayList<Parser_Token> pTokens, VariableHash varHash)
    {
        this.pTokens = pTokens;
        this.varHash = varHash;
        this.expTreeGen = new ExpresionTreeGenerator(varHash);
    }
    
    public P_Expresion parse() throws Exception
    {
        for(; index < pTokens.size(); index++)
        {
            Parser_Token pToken = pTokens.get(index);

            if(pToken instanceof ParserParentesisOpen)
            {
                index++;
                expTreeGen.añadirExpresion( extractParentesis() );
            }
            else
            {
                expTreeGen.añadirToken(pToken);
            }
        }
        
        return expTreeGen.finalizar();//retorna el arbol de expresiones en una expresion.
    }
    private P_Expresion extractParentesis() throws Exception
    {
        ArrayList<Parser_Token> tokens = new ArrayList<>();
        
        int openParentesisCounter = 1; //cuenta el primer parentesis
        
        for(; index < pTokens.size(); index++)
        {
            Parser_Token pToken = pTokens.get(index);
            
            if(pToken instanceof ParserParentesisOpen)
                openParentesisCounter++;
            else if(pToken instanceof ParserParentesisClose)
            {
                openParentesisCounter--;
                if(openParentesisCounter == 0)
                {
                    Parser_Aritmetico p = new Parser_Aritmetico(tokens, varHash);
                    return p.parse();
                }
            }
            
            tokens.add(pToken);
        }
        
        throw new Exception("open parentesis sin close parentesis");
    }
    public void definirVariable(String varName, Double valor)
    {
        varHash.add(varName, valor);
    }
}