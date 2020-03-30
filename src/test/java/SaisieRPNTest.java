import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import com.principal.SaisieRpn;

public class SaisieRPNTest {

  @Before
  public void setUp() throws Exception {}


  @Test
  public void testInput() {
    SaisieRpn inputRPN = new SaisieRpn();
    assertNotNull(inputRPN);
  }


}
