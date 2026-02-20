/* Projeto da calculadora deve implementar: 


    Seja a pilha P1 inicialmente vazia
    Para cada elemento da expressão:
        Se for um número, empilhe-o em P1 e volte ao passo 2
        Se for um operador, faça o seguinte:
            Desempilhe dois números da pilha P1
            Calcule a operação com esses dois números
            Empilhe em P1 o resultado da operação, e volte ao passo 2
    Ao final, o resultado deve ser o único valor existente em P1


    1 2 + .. .que equivale a 1 + 2
    1 2 + 3 * ... que equivale a (1 + 2) * 3
    1 2 + 3  4 + / .... que equivale a (1 + 2) / (3 + 4)
quer dizer, que consiga resolver expressões compostas por valores inteiros ou em ponto flutuante e operações básicas + (adição), - (subtração), * (multiplicação), / (divisão) e ^ (exponenciação).
Seu programa deve ler do teclado a expressão a ser calculada, calcular o resultado usando sua calculadora, e então apresentar o resultado na saída padrão (na tela). Se a expressão for inválida, ele deve mostrar a mensagem ERRO.

*/

import java.util.Scanner;

public class Calculadora{
  public static void main(String[] args) {
    System.out.println("Calculadora iniciada.");

    Scanner scanner = new Scanner(System.in);
    Pilha<String> pilhaNumeros = new Pilha<>();
    Pilha<String> pilhaDados = new Pilha<>();

    System.out.println("Digite a expressão a ser calculada (em notação pós-fixada):");
    String expressao = scanner.nextLine();
    StringBuilder filtro = new StringBuilder();
    for (int i = 0; i < expressao.length(); i++) {
      char c = expressao.charAt(i);
      if (c != '') {
        filtro.append(c);
      } else {
        if (filtro.length() > 0) {
          pilhaDados.empilha(filtro.toString());
          filtro.setLength(0);
        }
      }
      
    }
  }
} 
