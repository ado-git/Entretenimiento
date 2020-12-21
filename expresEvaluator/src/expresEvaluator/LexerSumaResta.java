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
public class LexerSumaResta extends Lexer_Base
{
    public LexerSumaResta()
    {
        super("[-\\+]",
                "[-\\+]");
    }
    
        @Override
    protected Parser_Token getParserTokenInstance(String token)
    {
        return new ParserSumaResta(token);
    }

}
