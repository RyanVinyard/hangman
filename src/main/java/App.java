
import java.io.Console;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();



      System.out.println("Welcome to hangman");
      //String sentance = myConsole.readLine();

      HangmanGame gameObject = new HangmanGame();
      gameObject.chooseWord();
      gameObject.drawHangman();
      gameObject.displayGuess();

      boolean flag = true;
      while(flag){
g
        gameObject.guessLetter();
        gameObject.drawHangman();
        flag = gameObject.displayGuess();
    }

  }
}
