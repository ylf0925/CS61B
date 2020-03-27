public class TestBody {
    public static void main(String[] args) {
    Body a = new Body(0,5,2,2,10, "earth.gif");
    Body b = new Body(0,-5,-2,-2,100,"jupiter.gif");
    double res = b.calcForceExertedBy(a);
        System.out.println(res);
    }
}
