import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import package_main.SaisieRPN;

public class SaisieRPNTest {

  @Before
  public void setUp() throws Exception {}


  @Test
  public void testInput() {
    SaisieRPN inputRPN = new SaisieRPN();
    assertNotNull(inputRPN);
  }


}
