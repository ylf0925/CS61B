import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator obn5 = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(obn5.equalChars('a', 'f'));
        assertTrue(obn5.equalChars('b', 'g'));
        assertFalse(obn5.equalChars('a', 'a'));
        assertFalse(obn5.equalChars('b', 'c'));
    }
}

