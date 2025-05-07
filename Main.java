import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.sound.sampled.*;

public class Main {
  public static void main(String[] args) {

String basePath = System.getProperty("user.home") + "\\Downloads\\Cutucatu\\dbg";

        System.out.println("Verificando diretório: " + basePath);
        File directory = new File(basePath);

        // Verifica se o diretório existe
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Diretório não encontrado ou não é um diretório válido.");
            return;
        }

        System.out.println("Diretório encontrado! Listando arquivos:");
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            System.out.println("- " + file.getName());
        }

        // Busca por arquivos .wav
        File audioFile = null;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.getName().toLowerCase().endsWith(".wav")) {
                audioFile = file;
                break;
            }
        }

        if (audioFile == null) {
            System.out.println("Nenhum arquivo .wav foi encontrado no diretório especificado.");
            return;
        }

        System.out.println("Arquivo encontrado: " + audioFile.getName());
        System.out.println("Caminho completo: " + audioFile.getAbsolutePath());
        System.out.println("Arquivo existe? " + audioFile.exists());

        // Toca o áudio com controle
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            Scanner scanner = new Scanner(System.in);
            String command = "";

            while (!command.equalsIgnoreCase("q")) {
                System.out.println("Comandos: p = play, s = stop, r = restart, q = quit");
                System.out.print("Digite um comando: ");
                command = scanner.nextLine();

                switch (command.toLowerCase()) {
                    case "p":
                        clip.start();
                        System.out.println("▶ Tocando áudio...");
                        break;
                    case "s":
                        clip.stop();
                        System.out.println("⏹ Áudio pausado.");
                        break;
                    case "r":
                        clip.setFramePosition(0);
                        clip.start();
                        System.out.println("🔄 Reiniciando áudio...");
                        break;
                    case "q":
                        clip.stop();
                        System.out.println("🛑 Saindo...");
                        break;
                    default:
                        System.out.println("Comando inválido.");
                }
            }
            scanner.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("⚠ Arquivo de áudio não suportado!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("⚠ Erro ao ler o arquivo!");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.out.println("⚠ Linha de áudio não disponível!");
            e.printStackTrace();
        }























    Scanner scanner = new Scanner(System.in);
    Matematica pontematematica = new Matematica("ponte", "ponte");
    Matematica[] matematica = new Matematica[3];
    Random dandadan = new Random();
    String resposta;
    int esc = 0;

    matematica[0]=new Matematica("questao 1","a");
    matematica[1]=new Matematica("questao 2","b");
    matematica[2]=new Matematica("questao 3","c");


    System.out.println("Bem vindos, Senhoras e Senhores, ao Mettaton Quiz Show!!!");

    int random = dandadan.nextInt(3);

    System.out.print("Escolha uma das seguintes materias para o Quiz:\n 1 - Matematica\n 2 - Fisica\n 3 - Artes\n");
    esc = scanner.nextInt();

    switch (esc) {
        case 1:
            System.out.println(matematica[random].getquestao());
            resposta = scanner.next();
            pontematematica.exibirExplicacao(random);
    }

    scanner.close();

    };


}
