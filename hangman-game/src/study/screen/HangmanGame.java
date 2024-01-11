package study.screen;
import java.util.Scanner;
import study.controllers.Game;
import study.controllers.Words;

public class HangmanGame {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao jogo da forca!");
        Game game = new Game();
        Words words = new Words();
        Scanner scanner = new Scanner(System.in);

        System.out.println("A palavra secreta: " + game.displayWord());
        System.out.println("Dica: Fruta");

        while (game.getAttempts() > 0 && !game.isWordGuessed()) {
            System.out.println("Você tem " + game.getAttempts() + " tentativas");
            System.out.println("Digite uma letra: ");
            String letter = scanner.nextLine().toUpperCase();
            if (game.checkLetter(letter)) {
                System.out.println("Você acertou uma letra!");
                System.out.println("A palavra secreta é : " + game.displayWord());
            } else {
                System.out.println("Você errou!");
                System.out.println("A palavra secreta é : " + game.displayWord());
            }
        }


        if (game.isWordGuessed()) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("Você perdeu!");
            System.out.println("A palavra secreta era: " + game.getSecretWord());
        }

        System.out.println("Deseja adicionar uma nova palavra? (s/n)");
        String answer = scanner.nextLine();

        if (answer.equals("s")) {
            System.out.println("Digite a nova palavra: ");
            String newWord = scanner.nextLine();
            words.addWord(newWord);
            System.out.println("A palavra " + newWord + " foi a adicionada!");
        }

        System.out.println("Obrigado por jogar!");
        
        scanner.close();
    }
}
