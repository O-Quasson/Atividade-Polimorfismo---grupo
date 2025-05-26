import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {

        // Caminho do diretório, se mudar o codigo explode
        String basePath = System.getProperty("user.home") + "\\Downloads\\Grupo\\dbg";

        System.out.println("Verificando diretório: " + basePath);
        File directory = new File(basePath);

        // busca o wav (porque essa bomba só lê wav)
        File audioFile = null;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile = file;
                break;
            };
        };

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nLights\n");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Camera\n");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ACTION!\n\n");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Música tema: " + audioFile.getName());

        // Controle de áudio
        Clip clip = null;
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        // Início do Quiz
        Scanner scanner = new Scanner(System.in);
        Random dandadan = new Random();
        int random = dandadan.nextInt(3);
        String resposta;
        int esc = 1;
        int anteriores[] = new int[2];

        // Instanciar as questões com polimorfismo
        Materia[] materias = new Materia[9];

        // Matemática
        materias[0] = new Matematica("Em uma progressão aritmética em que o primeiro termo é 23 e a razão é -6, a posição ocupada pelo elemento -13 é:\n\na) 8ª\nb) 5ª\nc) 6ª\nd) 7ª", "d", "A fórmula do termo geral de uma PA é:\n\nan = a1 + (n-1)r\n\nan é o termo geral\nn é a posição ocupada pelo termo em questão\nr é a razão da PA\na1 é o primeiro termo da progressão\n\nSubstituindo os valores dados no exercício na fórmula acima, teremos:\n\n-13 = 23 + (n-1)·(-6)\n\nA partir dessa equação simples, podemos chegar a conclusão de que O número -13 ocupa a 7ª posição.");
        materias[1] = new Matematica("Quantas senhas com 4 algarismos diferentes podemos escrever com os algarismos 1, 2, 3, 4, 5, 6, 7, 8,e 9?\n\na) 1498 senhas\nb) 2378 senhas\nc) 3024 senhas\nd) 4256 senhas", "c", "Como o exercício indica que não ocorrerá repetição nos algarismos que irão compor a senha, então teremos a seguinte situação:\n\n9 opções para o algarismo das unidades;\n8 opções para o algarismo das dezenas, visto que já utilizamos 1 algarismo na unidade e não pode repetir;\n7 opções para o algarismo das centenas, pois já utilizamos 1 algarismo na unidade e outro na dezena;\n6 opções para o algarismo do milhar, pois temos que tirar os que já usamos anteriormente.\n\nAssim, o número de senhas será dado por:\n\n9.8.7.6 = 3 024 senhas");
        materias[2] = new Matematica("Em um colégio, de 100 alunos, 80 gostam de sorvete de chocolate, 70 gostam de sorvete de creme e 60 gostam dos dois sabores. Quantos alunos não gostam de nenhum dos dois sabores?\n\nA) 0\nB) 10\nC) 20\nD) 30\nE) 40", "b", "Sabemos que o total de alunos é igual a 100, e que dos 80 que gostam de chocolate, 60 gostam também de creme, então 80 - 60 = 20 que gostam somente de chocolate. Com esse mesmo raciocínio 70 - 60 = 10, então 10 gostam somente de creme. Sendo assim, vamos somar o total de alunos que gostam somente de chocolate, somente de creme e de ambos:\n\n20 + 60 + 10 = 90\n\nComo 100 alunos foram consultados, então 100-90 = 10.\n10 não gostam de nenhum dos dois.\n");

        // Artes
        materias[3] = new Artes("Qual dos elementos abaixo NÃO é considerado um elemento básico das artes visuais?\n\na) Linha\nb) Cor\nc) Ritmo\nd) Textura", "c", "Ritmo faz parte da musica, portanto não se aplica aqui.\n");
        materias[4] = new Artes("As linguagens artísticas possibilitam diferentes formas de expressão e comunicação. \nAssinale a alternativa que apresenta corretamente uma característica comum às artes visuais, à música, ao teatro e à dança:\n\na) Todas utilizam exclusivamente a escrita como meio de expressão.\nb) São formas de linguagem que permitem expressar ideias, sentimentos e visões de mundo.\nc) Estão limitadas a contextos acadêmicos e formais.\nd) Devem seguir sempre regras fixas e tradicionais para serem consideradas arte.", "b", "As artes, em suas diversas linguagens, são meios de expressão que vão além das palavras. Por meio de sons, imagens, movimentos ou encenações, os artistas comunicam emoções, reflexões, críticas sociais, experiências pessoais ou coletivas. Essa característica é essencial em todas as linguagens artísticas.encial em todas as linguagens artísticas.\n");
        materias[5] = new Artes("Ao observar uma obra de arte, é possível desenvolver uma leitura crítica sobre seu contexto e seus significados. \nIsso acontece porque:\n\na) Toda obra de arte tem um único sentido que deve ser decorado.\nb) O papel do observador é apenas identificar o nome do artista e a data da obra.\nc) A interpretação de uma obra pode variar conforme o repertório e a vivência de cada pessoa.\nd) Obras de arte não devem ser questionadas ou analisadas, apenas admiradas.", "c", "A apreciação artística é subjetiva e influenciada por fatores como cultura, experiências de vida, conhecimentos prévios e até o momento emocional do observador. Por isso, diferentes pessoas podem interpretar uma mesma obra de maneiras distintas, e todas essas leituras são válidas.\n");

        // Física
        materias[6] = new Fisica("Se um veiculo altomotivo está no metro 10 de uma estrada retilinea, indo a 20m/s com uma aceleração de 5m/s^2, em 20 segundos, qual a posicao deste carro?\n1. o veiculo se esta no metro 1410\n2. o veiculo se esta no metro -1410\n3. o veiculo se esta no metro 1415\n4. o veiculo se esta no metro -1510","1","considerando que a formula do sorvetao seja S = S0 + v0.t + a.t^2/2 entao:\n S = 10 + 20.20 + 5.20.20/2\n S = 10 + 400 + 2000/2\n S = 10 + 400 + 1000\n S = 1410m\n");
        materias[7] = new Fisica("Uma crianca e sua mae estao em um circo, mais especificamente em uma sala de espelhos, a crianca esta na frente de um espelho concavo e a tal vertice deste esteja perfeitamente alinhada no chao, depois de um tempo a mae perguntou para a crianca como ela via o proprio reflexo, considerando que a crianca esta entre o vertice e o foco, qual sua resposta para a sua figura materna?\n1. estou me vendo pequena e ao contrario!\n2. estou me vendo igual mas ao contrario!\n3. estou eu nao consigo me ver!\n4. estou me vendo Maior!", "4", "a crianca respondeu que ela esta maior pois devido a sua localizacao (entre vertice e foco) a reflexao projetada é direita, maior e virtual.\n");
        materias[8] = new Fisica("considerando que uma caixa de 20kg esta sendo segurada por duas polias moveis, quanto ela pesa na ponta que esta a puxar?\n1. ela pesara o mesmo.\n2. ela pesara 5kg.\n3. ela pesara 10kg.\n4. ela pesara 80kg.", "2", "as polias moveis dividem o peso em dois, o calculo então se resume a (20/2)/2\nR = 10/2\nR = 5kg\n");

        System.out.println("Bem vindos, Senhoras e Senhores, ao Mettaton Quiz Show!!!");

        // Loop do Quiz
        while(esc!=0){
            System.out.print("\nEscolha uma das seguintes matérias para o Quiz (ou digite 0 para sair):\n1 - Matemática\n2 - Artes\n3 - Fisica\n");
            esc = scanner.nextInt();
            System.out.println("\n");

            switch (esc){
                
                case 0:
                    System.out.println("Você escolheu sair. Até mais!");
                    break;

                case 1:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);
                    break;

                case 2:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    break;
                
                case 3:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta);
                    break;

                default:
                    System.out.println("\nIsso não é uma das opções, meu querido telespectador, não tente estragar o show! Tente denovo, mas dessa vez sem nenhuma gracinha!");
            };
            // if (esc == 0) {
            //     System.out.println("Saindo do quiz. Até a próxima!");
            // }

            // if (esc < 1 || esc > 3) {
            //     System.out.println("Matéria não encontrada.");
            // }

            // Seleciona uma questão aleatória da matéria escolhida
            // int index = (esc - 1) * 3 + random;

            // Exibe a questão e espera a resposta
            // System.out.println(materias[index].getquestao());
            // resposta = scanner.next();
            // materias[index].exibirExplicacao(random);
        };

        scanner.close();
    };
};
