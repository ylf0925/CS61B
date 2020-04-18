public class Rose implements Plant {

    public int height;

    Rose(int h) {
        height = h;
    }


    @Override
    public void grow() {
        height += 1;
    }

    @Override
    public void photosynthesize() {
        System.out.println("Rose feel energized!!");
    }

    public static void main(String[] args) {
        Plant p = new Rose(4);
        p.grow();
        p.photosynthesize();
    }
}
