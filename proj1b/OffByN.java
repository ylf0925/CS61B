public class OffByN implements CharacterComparator {
    //instance variable
    private int diff;

    //Constructor
    public OffByN(int N) {
        diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == diff) {
            return true;
        } else {
            return false;
        }
    }

}
