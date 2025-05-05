import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Matematica[] matematica = new Matematica[3];
    Random dandadan = new Random();
    String resposta;

    matematica[0]=new Matematica("questao 1","a");
    matematica[1]=new Matematica("questao 2","b");
    matematica[2]=new Matematica("questao 3","c");


    System.out.println("Bem vindos, Senhoras e Senhores, ao Mettaton Quiz Show!!!");

    int random = dandadan.nextInt(2);

    System.out.println(matematica[random].getquestao());
    resposta = scanner.next();
    matematica.exibirExplicacao(random);

    scanner.close();

};


}
