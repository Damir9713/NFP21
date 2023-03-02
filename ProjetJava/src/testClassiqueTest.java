import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class testClassiqueTest {

@Test
public void testConfiguration() {
    String[] args = {"-C", "-K", "21", "-E", ".001", "-K", "100"};
    Configuration configuration = CLIClassique.configuration(args);
    assertEquals(configuration.mode, Mode.CREUSE);
    assertEquals(configuration.alpha, -1.0);
    assertEquals(configuration.epsilon, 0.001);
    assertEquals(configuration.indice, 100);
}
}