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
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double uniRadius = NBody.readRadius(filename);
        Body[] Planet = NBody.readBodies(filename);
        StdDraw.setScale(-uniRadius, uniRadius);
        StdDraw.enableDoubleBuffering();
        double Tau = 0;
        while (Tau <= T) {
            double[] xForces = new double[Planet.length];
            double[] yForces = new double[Planet.length];
            for (int j = 0; j < Planet.length; j++) {
                xForces[j] = Planet[j].calcNetForceExertedByX(Planet);
                yForces[j] = Planet[j].calcNetForceExertedByY(Planet);
            }
            for (int i = 0; i < Planet.length; i++) {
                Planet[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body body : Planet) {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Tau = Tau + dt;
        }

        StdOut.printf("%d\n", Planet.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planet.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planet[i].xxPos, Planet[i].yyPos, Planet[i].xxVel,
                    Planet[i].yyVel, Planet[i].mass, Planet[i].imgFileName);
        }
    }
}
