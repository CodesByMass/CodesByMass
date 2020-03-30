

import static org.junit.Assert.assertFalse;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import package_main.Interpreteur;

public class InterpreteurTest {

  private Stack<Double> dummy = new Stack<Double>();
  private Stack<Double> dummy2 = new Stack<Double>();

  @Before
  public void setUp() throws Exception {
    dummy.add((double) 2);
    dummy2.add((double) 2);

  }

  @Test
  public void testInterpreteur() {
    Interpreteur temp = new Interpreteur(dummy, dummy2);
    assertFalse((temp == null));

  }

  @Test
  public void testUndo() {
    //
  }

}
