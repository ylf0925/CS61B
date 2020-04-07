import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator obn3 = new OffByN(3);
    @Test
    public void testOffByN(){
        assertTrue(obn3.equalChars('a','d'));
        assertTrue(obn3.equalChars('b','e'));
        assertFalse(obn3.equalChars('a','a'));
        assertFalse(obn3.equalChars('b','c'));
    }
}
