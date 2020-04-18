public class ArrayLauncher {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        /*array = Array.insert(array,2077,3);
        array = Array.insert(array,1991,3);*/
        Array.reverse(array);
        int[] a = Array.replicate(array);
        System.out.println(a);
    }
}
