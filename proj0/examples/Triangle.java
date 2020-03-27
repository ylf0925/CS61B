import java.awt.*;

public class Triangle {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setPenRadius(0.05);
        StdDraw.setScale();
        StdDraw.setYscale(0,1000);
        StdDraw.enableDoubleBuffering();
        /*double t = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);
        StdDraw.point(0.5, t / 3.0);
        StdDraw.point(0.1, 0.1);
        StdDraw.circle(0.5,0.5,0.5);*/
        StdDraw.setPenColor(Color.blue);
        StdDraw.circle(500,500,200);
        StdDraw.text(200,200,"HelloWorld");
        StdDraw.show();
    }
}
