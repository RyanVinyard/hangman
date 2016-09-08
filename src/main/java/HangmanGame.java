import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.util.Random;
import java.util.Arrays;

public class HangmanGame {
  Console myConsole = System.console();

   String[] currentWord;
   List<String> guessedWord = new ArrayList<String>();
   String[] gameWords = {"ocean", "quick", "zebra", "bottle", "football"};
  private int missedGuesses = 0;
  private int allowedGuesses = 6;



  // Method Letter Guess
  public void guessLetter(){
    System.out.println("What is your guess?");
    String letter = myConsole.readLine();
    boolean flag = false;
    for(int i=0; i<currentWord.length; ++i){
      if(currentWord[i].equals(letter)) {
        guessedWord.set(i, letter);
        flag = true;
      }
    }
    if(!flag)
      missedGuesses++;

  }

  public void chooseWord(){
    Random rand = new Random();
    int  i = rand.nextInt(gameWords.length);
    currentWord = gameWords[i].split("");
    for(int j=0; j<currentWord.length; ++j){
      guessedWord.add("_");
    }
  }

  public boolean displayGuess(){



    for(int j=0; j<guessedWord.size(); ++j){
      System.out.print(guessedWord.get(j) + " ");
    }
    System.out.print(" " + "Wrong Answers: " + missedGuesses + "/" + allowedGuesses + "\n");

    if(missedGuesses >= allowedGuesses){
      System.out.println("You Hang!");
      return(false);
    }
    else if (hasWon()) {
      System.out.println("You Won!");
      return(false);
    }
    else{
      return(true);
    }


  }

  public boolean hasWon(){
    for(int j=0; j<currentWord.length; ++j){
      if(!currentWord[j].equals(guessedWord.get(j)))
        return(false);
    }
    return(true);
  }


public void drawHangman() {
  System.out.println("  ____");
  System.out.println(" |    |");

  if(missedGuesses==0){
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
  }

  else if(missedGuesses==1){
    System.out.println(" |    O");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
  }

  else if(missedGuesses==2){
    System.out.println(" |    O");
    System.out.println(" |    |");
    System.out.println(" |    |");
    System.out.println(" |");
    System.out.println(" |");
    System.out.println(" |");
  }
  else if(missedGuesses==3){
    System.out.println(" |    O");
    System.out.println(" |   /|");
    System.out.println(" |  / |");
    System.out.println(" |    |");
    System.out.println(" |");
    System.out.println(" |");
  }
  else if(missedGuesses==4){
    System.out.println(" |    O");
    System.out.println(" |   /|\\");
    System.out.println(" |  / | \\");
    System.out.println(" |    |");
    System.out.println(" |");
    System.out.println(" |");
  }
  else if(missedGuesses==5){
    System.out.println(" |    O");
    System.out.println(" |   /|\\");
    System.out.println(" |  / | \\");
    System.out.println(" |    |");
    System.out.println(" |   /");
    System.out.println(" |  /");
  }
  else if(missedGuesses==6){
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
