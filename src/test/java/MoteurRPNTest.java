import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.EmptyStackException;
import org.junit.Test;
import package_exceptions.MaxIntervalException;
import package_exceptions.MinIntervalException;
import package_exceptions.MissingOperandException;
import package_main.MoteurRPN;
import package_main.Operation;

public class MoteurRPNTest {

  @Test
  public void testMoteurRPN() {
    MoteurRPN temp = new MoteurRPN();
    assertNotNull(temp);
  }

  /*
   * @Test(expected=EmptyStackException.class) public void testEmptyStack() { MoteurRPN moteurRPN =
   * new MoteurRPN(); moteurRPN.getOperands(); }
   */

  @Test(expected = MissingOperandException.class)
  public void testComputingEmptyStack() throws MissingOperandException, EmptyStackException,
      MinIntervalException, MaxIntervalException {
    MoteurRPN moteurRPN = new MoteurRPN();
    moteurRPN.compute(Operation.PLUS);
  }

  @Test(expected = MissingOperandException.class)
  public void testWithOneOperandMissing() throws MissingOperandException, EmptyStackException,
      MinIntervalException, MaxIntervalException {
    MoteurRPN moteurRPN = new MoteurRPN();
    moteurRPN.addOperand(5);
    moteurRPN.compute(Operation.PLUS);
  }

  /*
   * @Test(expected=MaxIntervalException.class) public void testAddMax() { MoteurRPN moteurRPN = new
   * MoteurRPN(); //(moteurRPN.addOperand(99999999999999.0)); }
   */

  @Test()
  public void resultatOperationAvecCalcul() throws EmptyStackException, MaxIntervalException,
      MissingOperandException, MinIntervalException {
    MoteurRPN moteurRPN = new MoteurRPN();
    Operation plus = Operation.PLUS;
    double a, b, res;
    a = 5;
    b = 5;
    res = a + b;
    moteurRPN.addOperand(2);
    moteurRPN.addOperand(3);
    assertTrue(plus.eval(a, b) == res);

  }

}
