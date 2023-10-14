package Model.Command.Boolean;

import static org.junit.jupiter.api.Assertions.*;

import Model.TokenType.Token;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LessThanEqualTest {
  private ArrayList<Token> paramList;

  @BeforeEach
  void setUp() {
    paramList = new ArrayList<>();
  }

  @Test
  void Equal() {
    setUp();
    paramList.add(new Token("Constant", "50.0", true));
    paramList.add(new Token("Constant", "50.0", true));
    LessEqual lessEqual = new LessEqual(paramList);
    double result = lessEqual.execute();

    assert(result == 1.0);
  }

  @Test
  void Greater() {
    setUp();
    paramList.add(new Token("Constant", "100.0", true));
    paramList.add(new Token("Constant", "50.0", true));
    LessEqual lessEqual = new LessEqual(paramList);
    double result = lessEqual.execute();

    assert(result == 0.0);
  }

  @Test
  void Less() {
    setUp();
    paramList.add(new Token("Constant", "0.0", true));
    paramList.add(new Token("Constant", "50.0", true));
    LessEqual lessEqual = new LessEqual(paramList);
    double result = lessEqual.execute();

    assert(result == 1.0);
  }
}