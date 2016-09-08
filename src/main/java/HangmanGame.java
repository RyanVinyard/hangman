import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;


public class HangmanGame {

    private String[] currentWord;
    private List<String> guessedWord = new ArrayList<String>();
     List<String> guessedLetters = new ArrayList<String>();
    private String[] easyGameWords = {"cat", "dog", "fish", "book"};
    private String[] medGameWords = {"ocean", "quick", "zebra", "bottle", "football"};
    private String[] hardGameWords = {"enumeration", "immaculate", "chinook", "cephalopod", "scry"};
    private int missedGuesses = 0;
    private int allowedGuesses = 6;

  public void guessLetter(String letter){

    boolean flag = false;
    for(int i=0; i<currentWord.length; ++i){
      if(currentWord[i].equals(letter)) {
        guessedWord.set(i, letter);
        flag = true;
      }
    }
    
    if(!flag){
      boolean flag2 = true;
      for(int j=0; j < guessedLetters.size(); ++j){
        if(letter.equals(guessedLetters.get(j)))
          flag2 = false;
      }
      if(flag2){
        guessedLetters.add(letter);
        missedGuesses++;
      }
    }

  }

  public void chooseWord(String diffLevel){
    Random rand = new Random();
    String[] gameWords = easyGameWords;

    if(diffLevel.equals("medium"))
        gameWords = medGameWords;
    else if(diffLevel.equals("hard"))
        gameWords = hardGameWords;
    int  i = rand.nextInt(gameWords.length);
    currentWord = gameWords[i].split("");
    for(int j=0; j<currentWord.length; ++j){
      guessedWord.add("_");
    }
  }

  public boolean hasWon(){
    for(int j=0; j<currentWord.length; ++j){
      if(!currentWord[j].equals(guessedWord.get(j)))
        return(false);
    }
    return(true);
  }

  public int getMissedGuesses(){
    return(missedGuesses);
  }
  public int getAllowedGuesses(){
    return(allowedGuesses);
  }
  public int getGuessedWordSize(){
    return(guessedWord.size());
  }
  public String getGuessedCharAt(int i){
    return(guessedWord.get(i));
  }
}
