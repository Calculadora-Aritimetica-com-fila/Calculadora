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

public class Calculadora {
    public static void main(String[] args) {
        System.out.println("Calculadora iniciada.");

        //Cria a pilha dos Números digitados
        Scanner scanner = new Scanner(System.in);
        Pilha<Double> pilhaNumeros = new Pilha<>();


        System.out.println("Digite a expressão a ser calculada (em notação pós-fixada):");
        String expressao = scanner.nextLine();

        //Separa a expressão pelo Split
        String[] expressaoArray = expressao.split(" ");

        try {
            //Pega os operadores e os números:
            for (String stringDigitada : expressaoArray) {

                //Tenta converter tudo para número ( e se for, empilha eles):
                try {
                    double numeroDigitado = Double.parseDouble(stringDigitada);
                    pilhaNumeros.empilha(numeroDigitado);
                } catch (NumberFormatException e) {
                    //Se não é número, então é operador:
                    if (pilhaNumeros.comprimento() < 2) {
                        throw new RuntimeException();
                    }

                    //Desempilha os números:
                    double primeiro = pilhaNumeros.desempilha();
                    double segundo = pilhaNumeros.desempilha();

                    double resultado;

                    // Pega os operadores a partir da String Digitada
                    switch (stringDigitada) {
                        case "+":
                            resultado = primeiro + segundo;
                            break;
                        case "-":
                            resultado = primeiro - segundo;
                            break;
                        case "*":
                            resultado = primeiro * segundo;
                            break;
                        case "/":
                            resultado = primeiro / segundo;
                            break;
                        default:
                            throw new RuntimeException();
                    }
                    //Empilha o operador na fila
                    pilhaNumeros.empilha(resultado);
                }
            }
            //Se a pilha tiver o comprimento de 1:
            if (pilhaNumeros.comprimento() == 1) {
                System.out.println("O resultado é " + pilhaNumeros.desempilha());
            } else {
                System.out.println("F");
            }
            //Caso ele nem passe pelo For:
        } catch (Exception e) {
            System.out.println("F");
        }
        scanner.close();
    }
}
