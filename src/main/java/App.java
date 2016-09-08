
import java.io.Console;
import java.util.List;
import java.util.regex.*;

public class App {
  static Console myConsole = System.console();
  static HangmanGame gameObject = new HangmanGame();

  public static void main(String[] args) {

      System.out.println("Welcome to hangman, please choose your difficulty level (easy, medium, hard)");
      String diffLevel = myConsole.readLine();

      gameObject.chooseWord(diffLevel);
      drawHangman();

      boolean flag = displayGuess();
      while(flag){

        //gameObject.guessLetter();
        gameObject.guessLetter(inputLetter());
        drawHangman();
        flag = displayGuess();
    }

  }
  private static final Pattern LETTERS = Pattern.compile("\\p{Alpha}+");

  public static String inputLetter(){
    boolean flag;
    String letter;
    do {
      System.out.println("What is your guess?");
      letter = myConsole.readLine();
      if (letter.length() == 1 && LETTERS.matcher(letter).matches()){
        flag = false;

      } else{
        flag = true;
        System.out.println("Invalid input, try again");
      }

    } while(flag);

    return(letter);
  }
  public static boolean displayGuess(){

    for(int j=0; j < gameObject.getGuessedWordSize(); ++j){
      System.out.print(gameObject.getGuessedCharAt(j) + " ");
    }
    System.out.print(" " + "Wrong Answers: " + gameObject.getMissedGuesses() + "/" + gameObject.getAllowedGuesses() + " Missed Letters: " + gameObject.guessedLetters + "\n");

    if(gameObject.getMissedGuesses() >= gameObject.getAllowedGuesses()){
      System.out.println("You Hang!");
      return(false);
    }
    else if (gameObject.hasWon()) {
      System.out.println("You Won!");
      return(false);
    }
    else
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
