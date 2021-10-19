package m2_joaovitor_matheus_nicole;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringReader;

public class M2_JoaoVitor_Matheus_Nicole
{
  public static void main(String[] args) throws LexicalError, SemanticError
  {
    
    // "A = 10; B = 11; B = 111 + A * B; Show(B);";
    // "A = 110; B = 1; A = B * A + 111 / A; Show(A);";
    // "B= 1010; A=10; B = B / A * 111; Show(A);";
    
    String line =  "A=11; B=10; A=A^B; Show(A);";
      
    Sintatico sintatico = new Sintatico();
    Semantico semantico = new Semantico();
    Lexico lexico = new Lexico(line);
    
    sintatico.parse(lexico, semantico);
    System.out.println(" = ");
  }
}
