/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


prioridades:
+- binario: 0
/*        : 10
+- unario : 20

 */
package expresEvaluator;

/**
 *
 * @author ado
 */
public class ExpresionTreeGenerator
{
    ExpresionTree expTree = new ExpresionTree();
    protected VariableHash varHash = null;
    protected byte currentState = 0;

    private ExpresionTreeGenerator(){}
    public ExpresionTreeGenerator(VariableHash varHash)
    {
        this.varHash = varHash;
    }

    private byte state0(Parser_Token pToken) throws Exception
    {
        if(pToken instanceof ParserNumero)
        {        
            expTree.pushExpresion(new PExpresionNumero(Double.parseDouble(pToken.token)));
            
            return 2;
        }
        else if(pToken instanceof ParserVariable)
        {
            expTree.pushExpresion(new PExpresionVariable(pToken.token, varHash));
            
            return 2;
        }
        else if(pToken instanceof ParserSumaResta)
        {
            if(pToken.token.compareTo("-") == 0 )
            {
                expTree.pushOperador(new POperatorMenosUnario());
            }
            else
            {
                throw new Exception("operador invalido");
            }
            
            return 1;
        }
        else
            throw new Exception("entrada invalida:" + pToken.token);
    }
    private byte state1(Parser_Token pToken) throws Exception
    {   
        if(pToken instanceof ParserNumero)
        {
            expTree.pushExpresion(new PExpresionNumero(Double.parseDouble(pToken.token)));
            
            return 2;
        }
        else if(pToken instanceof ParserVariable)
        {
            expTree.pushExpresion(new PExpresionVariable(pToken.token, varHash));
            
            return 2;
        }
        else
            throw new Exception("entrada invalida:" + pToken.token);
        
        
    }
    private byte state2(Parser_Token pToken) throws Exception
    {
        if(pToken == null)//el final
        {
            expTree.calcularPila();
            return -1;//terminó.
        }
        else if(pToken instanceof ParserSumaResta)
        {

            if(pToken.token.compareTo("+") == 0 )
            {
                
                expTree.pushOperador(new POperatorSuma());
                
            }
            else if(pToken.token.compareTo("-") == 0 )
            {
                expTree.pushOperador(new POperatorResta());
            }
            else 
            {
                throw new Exception("operador invalido");
            }

            
            return 1;
        }
        else if(pToken instanceof ParserMultDiv)
        {
            if(pToken.token.compareTo("*") == 0 )
            {
                expTree.pushOperador(new POperatorMultip());
            }
            else if(pToken.token.compareTo("/") == 0 )
            {
                expTree.pushOperador(new POperatorDiv());
            }
            else 
            {
                throw new Exception("operador invalido");
            }            

            return 0;
        }
        else
            throw new Exception("entrada invalida:" + pToken.token);        
    }
    public void añadirToken(Parser_Token pToken) throws Exception
    {
        switch(currentState)
        {
            case 0:
                currentState = state0(pToken);
                break;
            case 1:
                currentState = state1(pToken);
                break;
            case 2:
                currentState = state2(pToken);
                break;
            default:
                throw new Exception("estado invalido");
        }
    }
    public P_Expresion finalizar() throws Exception
    {
        añadirToken(null);
        
        return expTree.popUltimaExpresion();
    }
    private byte state0Expr(P_Expresion expr)
    {
        expTree.pushExpresion(expr);
        
        return 2;
    }
    private byte state1Expr(P_Expresion expr)
    {
        expTree.pushExpresion(expr);

        return 2;
    }
    
    public void añadirExpresion(P_Expresion expr) throws Exception
    {
        switch(currentState)
        {
            case 0:
                currentState = state0Expr(expr);
                break;
            case 1:
                currentState = state1Expr(expr);
                break;
            default:
                throw new Exception("estado invalido");
        }
    }
}
