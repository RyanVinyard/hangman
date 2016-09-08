import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;


public class HangmanGame {

    private String[] currentWord;
    private List<String> guessedWord = new ArrayList<String>();
    private List<String> guessedLetters = new ArrayList<String>();
    private String[] easyGameWords = {"cat", "dog", "fish", "book"};
    private String[] medGameWords = {"ocean", "quick", "zebra", "bottle", "football"};
    private String[] hardGameWords = {"enumeration", "immaculate", "chinook", "cephalopod", "scry"};
    private int missedGuesses = 0;
    private int allowedGuesses = 6;


public void resetGame(){
  guessedWord = new ArrayList<String>();
  guessedLetters = new ArrayList<String>();
  missedGuesses = 0;
}

  public void setUserWord(String word){
    currentWord = word.split("");
    for(int j=0; j<currentWord.length; ++j){
      guessedWord.add("_");
    }
  }

  public void guessLetter(String letter){
    boolean goodGuess = false;
    for(int i=0; i<currentWord.length; ++i){
      if(currentWord[i].equals(letter)) {
        guessedWord.set(i, letter);
        goodGuess = true;
      }
    }

    if(!goodGuess){
      boolean uniqueLetter = true;
      for(int j=0; j < guessedLetters.size(); ++j)
        if(letter.equals(guessedLetters.get(j)))
          uniqueLetter = false;

      if(uniqueLetter){
        guessedLetters.add(letter);
        missedGuesses++;
      }
    }

  }

  public void chooseRandWord(String diffLevel){
    Random rand = new Random();
    String[] gameWords = easyGameWords;

    if(diffLevel.equals("medium"))
        gameWords = medGameWords;
    else if(diffLevel.equals("hard"))
        gameWords = hardGameWords;
    int  i = rand.nextInt(gameWords.length);
    setUserWord(gameWords[i]);
  }

  public boolean hasWonGame(){
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
  public String getGuessedLetters(){
    String returnString = "[";
    for(int j=0; j < guessedLetters.size(); ++j)
      returnString += guessedLetters.get(j) + " ";
    returnString += "]";
    return(returnString);
  }
  public String getCurrentWord(){

    String returnString = "";
    for(int j=0; j < currentWord.length; ++j)
      returnString += currentWord[j];
    return(returnString);
  }

}
