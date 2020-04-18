/**
 * manipulate raw array data
 */
public class Array {

    /**
     * Insert an integer on a specified index.
     */
    public static int[] insert(int[] arr, int item, int position) {
        int size = arr.length;
        int[] arycopy = new int[size + 1];
        for (int i = 0; i < size; i++) {
            arycopy[i] = arr[i];
        }
        if (position > item) {
            arycopy[size] = item;
        } else {
            Array.moveBack(arycopy, size, position);
            arycopy[position] = item;
        }
        arr = arycopy;
        return arr;
    }

    /**
     * moveBack method directly manipulate raw ary underneath.
     */
    private static void moveBack(int[] ary, int oldArySize, int targetIdx) {
        int currIdx = oldArySize - 1;
        for (; currIdx >= targetIdx; currIdx--) {
            ary[currIdx + 1] = ary[currIdx];
        }
    }

    public static void reverse(int[] arr) {
        int length = arr.length;
        int countStop = length / 2;
        int count = 0;
        if (length % 2 != 0) {
            countStop--;
        }
        int i = 0, j = arr.length - 1;
        while (count < countStop) {
            Array.swap(arr, i, j);
            count++;
            i++;
            j--;
        }
    }

    /**
     * subordinate method affiliated to reverse.
     */
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    /**
     * Given an int[], return an int[] which contains each element
     * */
    public static int[] replicate(int[] arr) {
        int length = arr.length;
        int[] arycopy = new int[0];
        int count = 0;
        int nextPos = 0;
        for (int i = 0; i < length; i++) {
            count = 0;
            while (count < arr[i]) {
                arycopy = Array.insert(arycopy, arr[i], nextPos);
                count++;
            }
            nextPos += count;
        }
        return arycopy;
    }
}
