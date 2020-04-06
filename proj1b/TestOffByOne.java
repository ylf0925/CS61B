import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        assertTrue(offByOne.equalChars('x','y'));
        assertTrue(offByOne.equalChars('c','d'));
        assertTrue(offByOne.equalChars('c','b'));
        assertFalse(offByOne.equalChars('X','y'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('c','c'));
        assertFalse(offByOne.equalChars('d','d'));
        assertFalse(offByOne.equalChars('a','w'));
    }


}