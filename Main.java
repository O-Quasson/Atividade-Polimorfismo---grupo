import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) {

        // Caminho do diretório, se mudar o codigo explode
        String basePath = System.getProperty("user.home") + "\\Downloads\\Grupo\\dbg";

        System.out.println("Verificando diretório: " + basePath);
        File directory = new File(basePath);

        // busca o wav
        File audioFile = null;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile = file;
                break;
            };
        };

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

        // Instanciar as questões de forma polimórfica
        Materia[] materias = new Materia[9];

        // Matemática
        materias[0] = new Matematica("Qual é a raiz quadrada de 16?", "4", "explicacao matematica 1");
        materias[1] = new Matematica("Qual é o valor de Pi (aproximado)?", "3.14", "explicacao matematica 2");
        materias[2] = new Matematica("Quantos lados tem um hexágono?", "6", "explicacao matematica 3");

        // Artes
        materias[3] = new Artes("Qual dos elementos abaixo NÃO é considerado um elemento básico das artes visuais? \n1) Linha\n2) Cor\n3) Ritmo\n4) Textura", "3", "explicacao artes 1");
        materias[4] = new Artes("Qual pintor é famoso por suas obras de paisagens com água?", "Monet", "explicacao artes 2");
        materias[5] = new Artes("Qual técnica utiliza carvão para desenhar?", "Desenho a carvão", "explicacao artes 3");

        // Física
        materias[6] = new Fisica("Qual é a unidade de medida da força?", "Newton", "explicacao fisica 1");
        materias[7] = new Fisica("Quem formulou a Lei da Gravitação Universal?", "Isaac Newton", "explicacao fisica 2");
        materias[8] = new Fisica("Qual é a velocidade da luz no vácuo (em m/s)?", "299792458", "explicacao fisica 3");

        System.out.println("Bem vindos, Senhoras e Senhores, ao Mettaton Quiz Show!!!");

        // Loop do Quiz
        while(esc!=0){
            System.out.print("\nEscolha uma das seguintes matérias para o Quiz (ou digite 0 para sair):\n1 - Matemática\n2 - Artes\n3 - Fisica\n");
            esc = scanner.nextInt();

            switch (esc){
                
                case 0:
                    System.out.println("Você escolheu sair. Até mais!");
                    break;

                case 1:
                    random = dandadan.nextInt(3);
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.next();
                    materias[random].exibirExplicacao(materias[random], resposta);
                    break;

                case 2:
                    random = dandadan.nextInt(3);
                    random = random + 3;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.next();
                    materias[random].exibirExplicacao(materias[random], resposta);
                    break;
                
                case 3:
                    random = dandadan.nextInt(3);
                    random = random + 6;
                    System.out.println(materias[random].getquestao());
                    resposta = scanner.next();
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
