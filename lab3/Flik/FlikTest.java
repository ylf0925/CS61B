import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test(timeout = 1000)
    public void testFlik() {
        int a = 2020;
        int b = 2020;
        System.out.println(Flik.isSameNumber(a,b));
    }
}
