/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresEvaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ado
 */
public class A_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        ArrayList<Parser_Token> list = testLexer();
//        
//        testParser(list);
        
        //testEvaluadorExpresionesAritmeticas();
        
        testEvaluador();
    }
    public static ArrayList<Parser_Token> testLexer()
    {   
        ArrayList<Parser_Token> list = null;
        
        //String input = " output2 = 20.11 /(val1)  * ( val2 + 5 * val3 ) / val4";
        String input = " output3 = -(((2+0))/(-(val3)+4)*(val1)*-1*7/(-5-10)*2*-5/6-2.3)";
        
        System.out.println("PROGRAM INPUT:");
        System.out.println(input);
        
/////////////////////////////////
        Lexer l = new Lexer();
        
        try
        {
            list = l.parse(input);
        }
        catch(Exception e)
        {
            System.out.println("Exception:" + e.getMessage());
            return null;
        }
/////////////////////////////////        
        
        
        
        System.out.println("Lexer - Salida:");
        for(Parser_Token pt : list)
        {
            System.out.print(pt.token + ",");
        }
        System.out.println();
        
        return list;
    }
    public static void testParser(ArrayList<Parser_Token> list)
    {
        try
        {
            Parser p = new Parser(list);

            p.definirVariable("val1", (double)5);
            p.definirVariable("val2", (double)4);
            p.definirVariable("val3", (double)3);
            p.definirVariable("val4", (double)8);

        
            System.out.println("Parser - Salida: ");
            
            P_Expresion exp = p.parse();
            System.out.println("resultado: " + exp.calcular());
            System.out.println("variable de salida: " + p.getSalida());
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.toString());
        }
        
        
    }
    
    public static void testEvaluadorExpresionesAritmeticas()
    {
        String input = " output3 = -(((2+0))/(-(val3)+4)*(val1)*-1*7/(-5-10)*2*-5/6-2.3)";
        
        System.out.println("Probando evaluador de expresiones de asignacion.");
        System.out.println("INPUT:" + input);
        
        try
        {
            Parser p = EvaluadorExpresionesDeAsignacion.lexInput(input);
            
            p.definirVariable("val1", (double)5);
            p.definirVariable("val2", (double)4);
            p.definirVariable("val3", (double)3);
            p.definirVariable("val4", (double)8);

            P_Expresion exp = p.parse();

            System.out.println("Calculo de expresion: " + exp.calcular());
            System.out.println("Variable de salida: " + p.getSalida());
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    public static void testEvaluador()
    {
        String input = "x=4+a;x=5+x;";
        
        System.out.println("INPUT:" + input);
        
        EvaluadorDeExpresiones evExp = new EvaluadorDeExpresiones(input);
        
        try
        {
            System.out.println("adding variable a = 3.0");
            evExp.addVariableEntrada("a", 3.0);
            Set<Map.Entry<String, VarSalida>> set = evExp.Eval();

            for(Map.Entry<String, VarSalida> e :  set)
            {
                System.out.println(e.getKey() + "=" +e.getValue().getValue());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
