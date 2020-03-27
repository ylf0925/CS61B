import java.lang.reflect.Array;

public class NBody {
    public static double readRadius(String R) {
        In in = new In(R);
        int numberOfPlanet = in.readInt();
        return in.readDouble();
    }

    public static Body[] readBodies(String R) {
        In in = new In(R);
        int numberOfPlanet = in.readInt();
        double radius = in.readDouble();
        Body[] ary = new Body[numberOfPlanet];
        for (int j = 0; j < numberOfPlanet; j++) {
            ary[j] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return ary;
    }

    public static void main(String[] args) {

       /* double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];*/

        double T = Double.parseDouble("157788000.0");
        double dt = Double.parseDouble("25000.0");
        String filename = "data/planets.txt";

        double universeRadius = NBody.readRadius(filename);
        Body[] bodyAry = NBody.readBodies(filename);
        StdDraw.setScale(-universeRadius, universeRadius);
        StdDraw.enableDoubleBuffering();
        double Tau = 0;
        while (Tau <= T) {
            double[] xForces = new double[bodyAry.length];
            double[] yForces = new double[bodyAry.length];
            for (int j = 0; j < bodyAry.length; j++) {
                xForces[j] = bodyAry[j].calcNetForceExertedByX(bodyAry);
                yForces[j] = bodyAry[j].calcNetForceExertedByY(bodyAry);
            }
            for (int i = 0; i < bodyAry.length; i++) {
                bodyAry[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body body : bodyAry) {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Tau = Tau + dt;
        }

        StdOut.printf("%d\n", bodyAry.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < bodyAry.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodyAry[i].xxPos, bodyAry[i].yyPos, bodyAry[i].xxVel,
                    bodyAry[i].yyVel, bodyAry[i].mass, bodyAry[i].imgFileName);
        }
    }
}
