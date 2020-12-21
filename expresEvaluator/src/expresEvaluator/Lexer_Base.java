/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 *
 */
public abstract class Lexer_Base {
    
    protected String testPattern = null;//este es el patron del caracter que identificara al resto del match
    protected Pattern p;
    
    private Lexer_Base(){}
    public Lexer_Base(String testPattern, String regexString)
    {
        this.testPattern = testPattern;
        
        p = Pattern.compile("^(" + regexString + ")");
    }
    
    public boolean test(char c)
    {
        Pattern p = Pattern.compile(this.testPattern);
        
        Matcher m = p.matcher(""+c);
        
        return m.find();
        
    }
    public GroupCapture find(String s, int start)
    {
        Matcher m = p.matcher(s.substring(start));

        if(m.find(0))
        {
            GroupCapture gc = new GroupCapture(getParserTokenInstance(m.group(1)), start + m.end());
            return gc;
        }
        else
        {
            return null;
        }        
    }
    protected abstract Parser_Token getParserTokenInstance(String token);
}
