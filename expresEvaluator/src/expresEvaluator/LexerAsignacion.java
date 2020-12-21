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
public class LexerAsignacion extends Lexer_Base
{
    public LexerAsignacion()
    {
        super("=",
                "=");
    }
    @Override
    protected Parser_Token getParserTokenInstance(String token)
    {
        return new ParserAsignacion(token);
    }
}
