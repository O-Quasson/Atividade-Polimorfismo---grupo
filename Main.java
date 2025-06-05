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
        String basePath = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\musica";
        String basePath2 = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\heart";
        String basePath3 = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\levelup";
        String basePath4 = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\light";
        String basePath5 = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\camera";
        String basePath6 = System.getProperty("user.home") + "\\Downloads\\Grupo\\audios\\action";
        File directory = new File(basePath);
        File directory2 = new File(basePath2);
        File directory3 = new File(basePath3);
        File directory4 = new File(basePath4);
        File directory5 = new File(basePath5);
        File directory6 = new File(basePath6);

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

        //prepara o áudio do good ending (para mais tarde)
        File audioFile3 = null;
        for (File file : Objects.requireNonNull(directory3.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile3 = file;
                break;
            };
        };

        File audioFile4 = null;
        for (File file : Objects.requireNonNull(directory4.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile4 = file;
                break;
            };
        };

        File audioFile5 = null;
        for (File file : Objects.requireNonNull(directory5.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile5 = file;
                break;
            };
        };

        File audioFile6 = null;
        for (File file : Objects.requireNonNull(directory6.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile6 = file;
                break;
            };
        };


        //início do show
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nLights\n");
        Clip clip4 = null;
        try (AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(audioFile4)) {
            clip4 = AudioSystem.getClip();
            clip4.open(audioStream4);
            clip4.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Camera\n");
        Clip clip5 = null;
        try (AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(audioFile5)) {
            clip5 = AudioSystem.getClip();
            clip5.open(audioStream5);
            clip5.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ACTION!\n\n");
        Clip clip6 = null;
        try (AudioInputStream audioStream6 = AudioSystem.getAudioInputStream(audioFile6)) {
            clip6 = AudioSystem.getClip();
            clip6.open(audioStream6);
            clip6.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(500);
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
        materias[0] = new Matematica("Em uma progressão aritmética glamourosamente matemática, com o primeiro termo sendo 23 e a razão sendo -6... em que posição brilha o fabuloso número -13?:\n\na) 8ª\nb) 5ª\nc) 6ª\nd) 7ª", "d");
        materias[1] = new Matematica("Quantas senhas fabulosas de quatro algarismos diferentes podemos criar usando os glamourosos dígitos de 1 a 9?! Suspense! Drama! Matemáticaaa~!\n\na) 1498 senhas\nb) 2378 senhas\nc) 3024 senhas\nd) 4256 senhas", "c");
        materias[2] = new Matematica("Em um colégio fabuloso com 100 alunos espetaculares, 80 deles se derretem por sorvete de chocolate, 70 deliram com o de creme, e 60 são tão gulosos que gostam dos dois sabores! Mas a verdadeira questão é... quantos desses pequenos humanos NÃO gostam de nenhum sorvete?!\n\nA) 0\nB) 10\nC) 20\nD) 30\nE) 40", "b");

        // Artes
        materias[3] = new Artes("Dentre os elementos a seguir, qual deles NÃO é considerado um elemento BÁ-SI-CO das artes visuais?\n\na) Linha\nb) Cor\nc) Ritmo\nd) Textura", "c");
        materias[4] = new Artes("As linguagens artísticas são tão diversas quanto meus circuitos de glamour~! Elas possibilitam formas fabulosas de expressão e comunicação! Mas me diga, querido humano... Qual das alternativas revela uma característica COMUM entre as artes visuais, a música, o teatro e a dança? Escolha com sabedoria — os refletores estão sobre você~!:\n\na) Todas utilizam exclusivamente a escrita como meio de expressão.\nb) São formas de linguagem que permitem expressar ideias, sentimentos e visões de mundo.\nc) Estão limitadas a contextos acadêmicos e formais.\nd) Devem seguir sempre regras fixas e tradicionais para serem consideradas arte.", "b");
        materias[5] = new Artes(" ME DIGA~: Por que, ao olhar uma obra de arte, você consegue fazer aquela leitura crítica cheia de estilo sobre o contexto e os significados escondidinhos?\n\na) Toda obra de arte tem um único sentido que deve ser decorado.\nb) O papel do observador é apenas identificar o nome do artista e a data da obra.\nc) A interpretação de uma obra pode variar conforme o repertório e a vivência de cada pessoa.\nd) Obras de arte não devem ser questionadas ou analisadas, apenas admiradas.", "c");

        // Física
        materias[6] = new Fisica("Um veículo ARRASANDO na reta, começando no metro 10, deslizando a 20 m/s, com uma aceleração superpoderosa de 5 m/s². Depois de 20 segundos de puro drama cinemático, onde estará essa máquina de velocidade?\n1. o veiculo se esta no metro 1410\n2. o veiculo se esta no metro -1410\n3. o veiculo se esta no metro 1415\n4. o veiculo se esta no metro -1510","1");
        materias[7] = new Fisica("Imagine: uma criança e sua mãe no meio de uma sala de espelhos — mas não qualquer espelho, um espelho CÔNCAVO, com o vértice coladinho no chão! A criança está exatamente entre o vértice e o foco, e a mãe, cheia de curiosidade, pergunta: 'Como você se vê, meu raio de luz?'. O que a pequena e fabulosa estrela respondeu para sua mãe?\n1. estou me vendo pequena e ao contrario!\n2. estou me vendo igual mas ao contrario!\n3. estou eu nao consigo me ver!\n4. estou me vendo Maior!", "4");
        materias[8] = new Fisica("Temos uma caixa de 20 kg, segurada por duas polias móveis — uma verdadeira dança das forças no ar! Agora me diga, com toda a sua inteligência cintilante: qual é o peso sentido na ponta que está puxando essa belezura?\n1. ela pesara o mesmo.\n2. ela pesara 5kg.\n3. ela pesara 10kg.\n4. ela pesara 80kg.", "2");

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
                    //para a música tema para não causar interferência no som
                    clip.stop();

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    Clip clip3 = null;
                    try (AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(audioFile3)) {
                        clip3 = AudioSystem.getClip();
                        clip3.open(audioStream3);
                        clip3.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace();
                    } 

                    System.out.print("Good Ending\n\nOOOH YES~! Parabéns, humano fabulooooso! Você respondeu TODAS as questões do meu ultra magnífico quiz! Como recompensa, prepare-se...para um glorioso PARABÉNS e um tapinha absolutamente deslumbrante nas costas~!\n\n");

                    try {
                        Thread.sleep(1100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };

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
