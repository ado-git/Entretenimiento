/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author ado
 */
public class Lexer {
    ArrayList<Lexer_Base> clases;
    
    public Lexer()
    {
        this.clases = new ArrayList<>();
        
        this.clases.add(new LexerVariable());
        this.clases.add(new LexerSumaResta());
        this.clases.add(new LexerMultDiv());
        this.clases.add(new LexerParentesisOpen());
        this.clases.add(new LexerParentesisClose());
        this.clases.add(new LexerNumero());
        this.clases.add(new LexerAsignacion());
        
    }
    public ArrayList<Parser_Token> parse(String s) throws Exception
    {
        ArrayList<Parser_Token> list = new ArrayList<>();
        
        final int len = s.length();
        int i = 0,y;
        
        while (i < len)
        {
            //skip spaces.
            i = getWhiteSpace(s, i);
            if(i >= len)
                break;
            
            //get items
            GroupCapture gc = new GroupCapture(null,0);
            y = getItem(s, i, gc);
            
            if(y >= 0)
            {
                list.add(gc.parser_token);
                i = y;
            }
            else
            {
                throw new Exception("parse: ha ocurrido un error despues de la posicion: " + i);
            }
        }
        
        return list;
    }
    
       
    private int getItem(String s, int i, final GroupCapture gcRef) throws Exception
    {
        for(Lexer_Base ic : this.clases)
        {
            if(ic.test(s.charAt(i)))
            {
                GroupCapture gcTemp = ic.find(s, i);

                if(gcTemp != null)
                {
                    gcRef.parser_token = gcTemp.parser_token;
                    gcRef.nextPos = gcTemp.nextPos;
                    
                    return gcTemp.nextPos;
                }
                else
                {
                    throw new Exception("getItem: no funcionó el patrón");
                }
            }                
        }
        
        return -1;
    }
    private int getWhiteSpace(String s, int i)
    {
        Pattern p = Pattern.compile("^\\s*");
        
        Matcher m = p.matcher(s.substring(i));
        
        if(m.find(0))
            return i + m.end();
        
        return i;
    }
}
