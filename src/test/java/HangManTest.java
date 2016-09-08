import org.junit.*;
import static org.junit.Assert.*;


public class HangmanTest {

  @Test
  public void hasWonGame_detirminesWinState_bool1() {
    HangmanGame gameObject = new HangmanGame();
    gameObject.chooseWord("easy");
    boolean test = gameObject.hasWonGame();
     assertEquals(false, test);
  }


}
