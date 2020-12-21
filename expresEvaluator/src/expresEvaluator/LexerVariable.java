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
public class LexerVariable extends Lexer_Base
{
    public LexerVariable()
    {
        super("[a-zA-Z]",
                "[a-zA-Z]\\w*");
    }
    
        @Override
    protected Parser_Token getParserTokenInstance(String token)
    {
        return new ParserVariable(token);
    }

}
