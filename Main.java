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
        String basePath2 = System.getProperty("user.home") + "\\Downloads\\Grupo\\dbg2";
        File directory = new File(basePath);
        File directory2 = new File(basePath2);

        // busca o wav da música tema (porque essa bomba só lê wav)
        File audioFile = null;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile = file;
                break;
            };
        };

        //prepara o áudio do coração quebrando (para mais tarde)
        File audioFile2 = null;
        for (File file : Objects.requireNonNull(directory2.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile2 = file;
                break;
            };
        };

        //início do show
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

        // inicia a música tema
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
        String esc;
        int anteriores[] = new int[2];
        Ascii ascii = new Ascii("n");
        int tentativa = 0;
        int x = 1;

        // Instanciar as questões com polimorfismo
        Materia[] materias = new Materia[9];

        // Matemática
        materias[0] = new Matematica("Em uma progressão aritmética em que o primeiro termo é 23 e a razão é -6, a posição ocupada pelo elemento -13 é:\n\na) 8ª\nb) 5ª\nc) 6ª\nd) 7ª", "d");
        materias[1] = new Matematica("Quantas senhas com 4 algarismos diferentes podemos escrever com os algarismos 1, 2, 3, 4, 5, 6, 7, 8,e 9?\n\na) 1498 senhas\nb) 2378 senhas\nc) 3024 senhas\nd) 4256 senhas", "c");
        materias[2] = new Matematica("Em um colégio, de 100 alunos, 80 gostam de sorvete de chocolate, 70 gostam de sorvete de creme e 60 gostam dos dois sabores. Quantos alunos não gostam de nenhum dos dois sabores?\n\nA) 0\nB) 10\nC) 20\nD) 30\nE) 40", "b");

        // Artes
        materias[3] = new Artes("Qual dos elementos abaixo NÃO é considerado um elemento básico das artes visuais?\n\na) Linha\nb) Cor\nc) Ritmo\nd) Textura", "c");
        materias[4] = new Artes("As linguagens artísticas possibilitam diferentes formas de expressão e comunicação. \nAssinale a alternativa que apresenta corretamente uma característica comum às artes visuais, à música, ao teatro e à dança:\n\na) Todas utilizam exclusivamente a escrita como meio de expressão.\nb) São formas de linguagem que permitem expressar ideias, sentimentos e visões de mundo.\nc) Estão limitadas a contextos acadêmicos e formais.\nd) Devem seguir sempre regras fixas e tradicionais para serem consideradas arte.", "b");
        materias[5] = new Artes("Ao observar uma obra de arte, é possível desenvolver uma leitura crítica sobre seu contexto e seus significados. \nIsso acontece porque:\n\na) Toda obra de arte tem um único sentido que deve ser decorado.\nb) O papel do observador é apenas identificar o nome do artista e a data da obra.\nc) A interpretação de uma obra pode variar conforme o repertório e a vivência de cada pessoa.\nd) Obras de arte não devem ser questionadas ou analisadas, apenas admiradas.", "c");

        // Física
        materias[6] = new Fisica("Se um veiculo altomotivo está no metro 10 de uma estrada retilinea, indo a 20m/s com uma aceleração de 5m/s^2, em 20 segundos, qual a posicao deste carro?\n1. o veiculo se esta no metro 1410\n2. o veiculo se esta no metro -1410\n3. o veiculo se esta no metro 1415\n4. o veiculo se esta no metro -1510","1");
        materias[7] = new Fisica("Uma crianca e sua mae estao em um circo, mais especificamente em uma sala de espelhos, a crianca esta na frente de um espelho concavo e a tal vertice deste esteja perfeitamente alinhada no chao, depois de um tempo a mae perguntou para a crianca como ela via o proprio reflexo, considerando que a crianca esta entre o vertice e o foco, qual sua resposta para a sua figura materna?\n1. estou me vendo pequena e ao contrario!\n2. estou me vendo igual mas ao contrario!\n3. estou eu nao consigo me ver!\n4. estou me vendo Maior!", "4");
        materias[8] = new Fisica("considerando que uma caixa de 20kg esta sendo segurada por duas polias moveis, quanto ela pesa na ponta que esta a puxar?\n1. ela pesara o mesmo.\n2. ela pesara 5kg.\n3. ela pesara 10kg.\n4. ela pesara 80kg.", "2");

        System.out.println("Bem vindos, Senhoras e Senhores, ao Mettaton Quiz Show!!!");

        // Loop do Quiz
        while(x!=0){
            System.out.print("\nEscolha uma das seguintes matérias para o Quiz (ou digite 0 para sair):\n1 - Matemática\n2 - Artes\n3 - Fisica\n");
            esc = scanner.next();
            x = Integer.valueOf(esc);
            System.out.println("\n");

            switch (x){
                
                case 0:
                if(tentativa>=9){
                    System.out.print("Good Ending\n\nOOOH YES~! Parabéns, humano fabulooooso! Você respondeu TODAS as questões do meu ultra magnífico quiz! Como recompensa, prepare-se...para um glorioso PARABÉNS e um tapinha absolutamente deslumbrante nas costas~!\n\n");
                }else{
                    //https://rootstack.com/en/blog/java-clear-screen
                    //limpa a tela para colocar o ascii
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    //para a música tema para não causar interferência no som
                    clip.stop();
    

                    //coração normal
                    ascii.heart1();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };

                    //som do coração quebrando
                    Clip clip2 = null;
                    try (AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(audioFile2)) {
                        clip2 = AudioSystem.getClip();
                        clip2.open(audioStream2);
                        clip2.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace();
                    } 

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    //coração quebrado
                    ascii.heart2();
                    try {
                        Thread.sleep(1250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };

                    System.out.println("GAME OVER\n\nDica: Tente responder todas as questões");
                };
                break;

                case 1:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    break;

                case 2:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    break;
                
                case 3:
                    random = dandadan.nextInt(3);
                    anteriores[0] = random;
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while(anteriores[0]==random);
                    anteriores[1] = random;
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    do{
                        random = dandadan.nextInt(3);
                    }while((anteriores[0]==random)||(anteriores[1]==random));
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.nextLine();
                    materias[random].exibirExplicacao(materias[random], resposta, random);
                    tentativa = tentativa + 1;

                    break;

                default:
                    System.out.println("\nIsso não é uma das opções, meu querido telespectador, não tente estragar o show! Tente denovo, mas dessa vez sem nenhuma gracinha!");
            };
            
        };

        scanner.close();
    };
};