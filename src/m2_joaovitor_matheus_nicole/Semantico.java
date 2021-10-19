package m2_joaovitor_matheus_nicole;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
  Stack stack = new Stack();
  Map<String, Integer> mapString = new HashMap<String, Integer>();
  String Resultado;

  public int getResult()
  {
    return ((Integer)stack.peek()).intValue();
  }

  public void executeAction(int action, Token token)
  {
    Integer a, b;
    String b_s;
    String a_s; 
    int b_i; 
    int a_i; 
    System.out.println(action);
    switch (action) // AQUI EH NA BASE DA GAMBIARRA
    {
      case 1: // DECLARA VARIAVEL
         stack.push(mapString.get(token.getLexeme()));
          break;
          
      case 2: // DECLARA NUMERO
        stack.push(Integer.parseInt(token.getLexeme()));
        break;
          
      case 3: // FAZ EXP
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        
        b_s = Integer.toString(b);
        a_s = Integer.toString(a);
        
        b_i = Integer.parseInt(b_s,2);
        a_i = Integer.parseInt(a_s,2);
        
        System.out.println(" exp | VALOR A:" + Integer.toString(a) + "  VALOR B:" + Integer.toString(b));
        
        /*
        ESSA GAMBIARRA EXISTE POIS:
            Podem ocorrer problemas na hora de transformar os valor entre String binaria e Int, ja que nao sabemos como o dado 
            vai ser recebido fazemos try's transformando o dado, podendo ser 4 possibilidades
            - A ser um valor binario em String
            - B ser um valor binario em String
            - A & B serem valores binarios em string
            - Nem A ou B são valores binarios em String
        */
        
        try{ // Caso os dois valores sejam String em binario
            b_i = Integer.parseInt(b_s,2);
            a_i = Integer.parseInt(a_s,2);
            Double exponencial = Math.pow(a_i, b_i);
            stack.push(exponencial.intValue());
        }catch(Exception e){
            try{ // caso A seja um valor String binario
                a_i = Integer.parseInt(a_s,2);
                Double exponencial = Math.pow(a_i, b);
                 stack.push(exponencial.intValue());
            }catch(Exception f){
                try{ // caso B seja um valor String binario
                    b_i = Integer.parseInt(b_s,2);
                    Double exponencial = Math.pow(a, b_i);
                    stack.push(exponencial.intValue());
                }catch(Exception g){ // caso os dois sejam Int's
                    Double exponencial = Math.pow(a, b);
                    stack.push(exponencial.intValue());
                }
            }
        }
        break;
        
      case 4: // FAZ MULTIPLICAÇAO
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        
        b_s = Integer.toString(b);
        a_s = Integer.toString(a);
        
        System.out.println(" MULT | VALOR A:" + Integer.toString(a) + "  VALOR B:" + Integer.toString(b));
         
         /*
        ESSA GAMBIARRA EXISTE POIS:
            Podem ocorrer problemas na hora de transformar os valor entre String binaria e Int, ja que nao sabemos como o dado 
            vai ser recebido fazemos try's transformando o dado, podendo ser 4 possibilidades
            - A ser um valor binario em String
            - B ser um valor binario em String
            - A & B serem valores binarios em string
            - Nem A ou B são valores binarios em String
        */
        
        try{
            b_i = Integer.parseInt(b_s,2);
            a_i = Integer.parseInt(a_s,2);
            stack.push(new Integer(a_i * b_i));
        }catch(Exception e){
            try{
                a_i = Integer.parseInt(a_s,2);
                stack.push(new Integer(a_i * b));
                break;
            }catch(Exception f){
                try{
                    b_i = Integer.parseInt(b_s,2);
                    stack.push(new Integer(a * b_i));
                    break;
                }catch(Exception g){
                    stack.push(new Integer(a * b));
                }
            }
        }
        break;
          
      case 5: // FAZ DIVISAO
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        
        b_s = Integer.toString(b);
        a_s = Integer.toString(a);
        
        System.out.println("DIV | VALOR A:" + Integer.toString(a) + "  VALOR B:" + Integer.toString(b));
        
         /*
        ESSA GAMBIARRA EXISTE POIS:
            Podem ocorrer problemas na hora de transformar os valor entre String binaria e Int, ja que nao sabemos como o dado 
            vai ser recebido fazemos try's transformando o dado, podendo ser 4 possibilidades
            - A ser um valor binario em String
            - B ser um valor binario em String
            - A & B serem valores binarios em string
            - Nem A ou B são valores binarios em String
        */
        
       try{
            b_i = Integer.parseInt(b_s,2);
            a_i = Integer.parseInt(a_s,2);
            stack.push(new Integer(a_i / b_i));
        }catch(Exception e){
           try{
                a_i = Integer.parseInt(a_s,2);
                stack.push(new Integer(a_i / b));
            }catch(Exception f){
                try{
                    b_i = Integer.parseInt(b_s,2);
                    stack.push(new Integer(a / b_i));
                }catch(Exception g){
                    stack.push(new Integer(a / b));
                }
            }
        }
        break;
          
      case 6: // FAZ SUBTRACAO
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        
        b_s = Integer.toString(b);
        a_s = Integer.toString(a);
        System.out.println(" SUB | VALOR A:" + Integer.toString(a) + "  VALOR B:" + Integer.toString(b));
        
          /*
        ESSA GAMBIARRA EXISTE POIS:
            Podem ocorrer problemas na hora de transformar os valor entre String binaria e Int, ja que nao sabemos como o dado 
            vai ser recebido fazemos try's transformando o dado, podendo ser 4 possibilidades
            - A ser um valor binario em String
            - B ser um valor binario em String
            - A & B serem valores binarios em string
            - Nem A ou B são valores binarios em String
        */
        
        try{
            b_i = Integer.parseInt(b_s,2);
            a_i = Integer.parseInt(a_s,2);
            stack.push(new Integer(a_i - b_i));
        }catch(Exception e){
            try{
                a_i = Integer.parseInt(a_s,2);
                stack.push(new Integer(a_i - b));
            }catch(Exception f){
                try{
                    b_i = Integer.parseInt(b_s,2);
                    stack.push(new Integer(a - b_i));
                }catch(Exception g){
                    stack.push(new Integer(a - b));
                }
            }
        }
        break;
          
      case 7: // FAZ SOMA
        b = (Integer) stack.pop();
        a = (Integer) stack.pop();
        
        System.out.println("VALOR A:" + Integer.toString(a) + "  VALOR B:" + Integer.toString(b));
        
        b_s = Integer.toString(b);
        a_s = Integer.toString(a);
        
          /*
        ESSA GAMBIARRA EXISTE POIS:
            Podem ocorrer problemas na hora de transformar os valor entre String binaria e Int, ja que nao sabemos como o dado 
            vai ser recebido fazemos try's transformando o dado, podendo ser 4 possibilidades
            - A ser um valor binario em String
            - B ser um valor binario em String
            - A & B serem valores binarios em string
            - Nem A ou B são valores binarios em String
        */
        
        try{
            b_i = Integer.parseInt(b_s,2);
            a_i = Integer.parseInt(a_s,2);
            stack.push(new Integer(a_i + b_i));
        }catch(Exception e){
            try{
                a_i = Integer.parseInt(a_s,2);
                stack.push(new Integer(a_i + b));
            }catch(Exception f){
                try{
                    b_i = Integer.parseInt(a_s,2);
                    stack.push(new Integer(a + b_i));
                }catch(Exception g){
                    stack.push(new Integer(a + b));
                }
            }
        }       
        break;
          
      case 8: // FAZ O SHOW
        System.out.println("Resultado:" + Integer.toBinaryString(mapString.get(Resultado)) );
        break;
          
      case 9: // FAZ IGUALDADE
        mapString.put(Resultado, (Integer) stack.pop());
        break;
          
      case 10: // DECLARA VARIAVEL DE RESULTADO
       Resultado = token.getLexeme();
       break;
      
    }
  }
}