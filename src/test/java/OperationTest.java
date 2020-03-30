import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.principal.Operation;



public class OperationTest {

  double a, b;

  @Before
  public void setUp() {

    a = 5;
    b = 2;
  }

  @Test
  public void testPlus() {
    Operation op = Operation.PLUS;
    assertNotNull(op);
  }

  @Test
  public void testSymbPlus() {
    Operation op = Operation.PLUS;
    assertTrue(op.getOperation() == '+');
  }

  @Test
  public void testMoins() {
    Operation op = Operation.MOINS;
    assertNotNull(op);
  }

  @Test
  public void testSymbMoins() {
    Operation op = Operation.MOINS;
    assertTrue(op.getOperation() == '-');
  }

  @Test
  public void testMult() {
    Operation op = Operation.MULT;
    assertNotNull(op);
  }

  @Test
  public void testSymbMult() {
    Operation op = Operation.MULT;
    assertTrue(op.getOperation() == '*');
  }

  @Test
  public void testDiv() {
    Operation op = Operation.DIV;
    assertNotNull(op);
  }

  @Test
  public void testSymbDiv() {
    Operation op = Operation.DIV;
    assertTrue(op.getOperation() == '/');
  }

  @Test
  public void testMod() {
    Operation op = Operation.MOD;
    assertNotNull(op);
  }

  @Test
  public void testSymbMod() {
    Operation op = Operation.MOD;
    assertTrue(op.getOperation() == '%');
  }

  @Test
  public void testEvalPlus() {
    Operation operandPlus = Operation.PLUS;
    assertEquals(a + b, operandPlus.eval(a, b), 0);
  }

  @Test
  public void testEvalMoins() {
    Operation operandMoins = Operation.MOINS;
    assertEquals(a - b, operandMoins.eval(a, b), 0);

  }

  @Test
  public void testEvalDiv() {
    Operation operandDiv = Operation.DIV;
    assertEquals(a / b, operandDiv.eval(a, b), 0);
  }

  @Test
  public void testEvalMult() {
    Operation operandMult = Operation.MULT;
    assertEquals(a * b, operandMult.eval(a, b), 0);
  }

  @Test
  public void testEvalMod() {
    Operation operandMod = Operation.MOD;
    assertEquals(a % b, operandMod.eval(a, b), 0);
  }

  @Test(expected = ArithmeticException.class)
  public void testZeroDivision() throws ArithmeticException {
    Operation operandDiv = Operation.DIV;
    assertNotEquals(1, operandDiv.eval(10, 0));
  }

  @Test(expected = ArithmeticException.class)
  public void testModZero() throws ArithmeticException {
    Operation operandMod = Operation.MOD;
    assertNotEquals(1, operandMod.eval(10, 0));
  }

}

