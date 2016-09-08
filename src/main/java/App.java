
import java.io.Console;
import java.util.List;
import java.util.regex.*;

public class App {
  static Console myConsole = System.console();
  static HangmanGame gameObject = new HangmanGame();

  public static void main(String[] args) {
    String newGame = "yes";
    do{

      System.out.println("Welcome to hangman, please choose your difficulty level (easy, medium, hard, custom)");
      String diffLevel = myConsole.readLine().toLowerCase();

      if(diffLevel.equals("custom")){
        System.out.println("Enter the word you want to use: ");
        String userWord = myConsole.readLine();
        clearScreen();
        gameObject.setUserWord(userWord);
      }
      else
        gameObject.chooseRandWord(diffLevel);

      drawHangman();
      boolean gameOn = displayGuess();

      while(gameOn){
        gameObject.guessLetter(inputLetter());
        clearScreen();
        drawHangman();
        gameOn = displayGuess();
      }
      gameObject.resetGame();

      System.out.println("Play another game (yes or no)?");
      newGame = myConsole.readLine();
    } while (!newGame.equals("no"));

  }
  private static final Pattern LETTERS = Pattern.compile("\\p{Alpha}+");

  public static void clearScreen(){
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }
  public static String inputLetter(){
    boolean invalidLetter;
    String letter;
    do {
      System.out.println("What is your guess?");
      letter = myConsole.readLine().toLowerCase();
      if (letter.length() == 1 && LETTERS.matcher(letter).matches())
        invalidLetter = false;
      else {
        invalidLetter = true;
        System.out.println("Invalid input, try again.");
      }

    } while(invalidLetter);

    return(letter);
  }

  public static boolean displayGuess(){

    System.out.print("Status: ");
    for(int j=0; j < gameObject.getGuessedWordSize(); ++j){
      System.out.print(gameObject.getGuessedCharAt(j) + " ");
    }
    System.out.print("" + "\nWrong Answers: " + gameObject.getMissedGuesses() + "/" + gameObject.getAllowedGuesses() + "\nWrong Letters: " + gameObject.getGuessedLetters() + "\n");

    if(gameObject.getMissedGuesses() >= gameObject.getAllowedGuesses()){
      System.out.println("You got Hanged! The word was: " + gameObject.getCurrentWord());
      return(false);
    }
    else if (gameObject.hasWonGame()) {
      System.out.println("You Won and live to see another day!");
      return(false);
    }
    return(true);
  }

  public static void drawHangman(){
    System.out.println("  ____");
    System.out.println(" |    |");

    if(gameObject.getMissedGuesses()==0){
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
    }

    else if(gameObject.getMissedGuesses()==1){
      System.out.println(" |    O");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
    }

    else if(gameObject.getMissedGuesses()==2){
      System.out.println(" |    O");
      System.out.println(" |    |");
      System.out.println(" |    |");
      System.out.println(" |");
      System.out.println(" |");
      System.out.println(" |");
    }
    else if(gameObject.getMissedGuesses()==3){
      System.out.println(" |    O");
      System.out.println(" |   /|");
      System.out.println(" |  / |");
      System.out.println(" |    |");
      System.out.println(" |");
      System.out.println(" |");
    }
    else if(gameObject.getMissedGuesses()==4){
      System.out.println(" |    O");
      System.out.println(" |   /|\\");
      System.out.println(" |  / | \\");
      System.out.println(" |    |");
      System.out.println(" |");
      System.out.println(" |");
    }
    else if(gameObject.getMissedGuesses()==5){
      System.out.println(" |    O");
      System.out.println(" |   /|\\");
      System.out.println(" |  / | \\");
      System.out.println(" |    |");
      System.out.println(" |   /");
      System.out.println(" |  /");
    }
    else if(gameObject.getMissedGuesses()==6){
      System.out.println(" |    O");
      System.out.println(" |   /|\\");
      System.out.println(" |  / | \\");
      System.out.println(" |    |");
      System.out.println(" |   / \\");
      System.out.println(" |  /   \\");
    }

    System.out.println("_|_");
    System.out.println("|   |______");
    System.out.println("|          |");
    System.out.println("|__________|");
    return;
  }
}
