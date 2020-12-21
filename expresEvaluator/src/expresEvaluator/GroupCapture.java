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
public class GroupCapture
{
    public Parser_Token parser_token;
    public int nextPos;
    
    public GroupCapture(Parser_Token parser_token, int nextPos)
    {
        this.parser_token = parser_token;
        this.nextPos = nextPos;
    }
}
