import java.lang.reflect.Array;

public class NBody {
    public static double readRadius(String R) {
        In in = new In(R);
        int numberOfPlanet = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readBodies(String R) {
        In in = new In(R);
        int numberOfPlanet = in.readInt();
        double radius = in.readDouble();
        Planet[] ary = new Planet[numberOfPlanet];
        for (int j = 0; j < numberOfPlanet; j++) {
            ary[j] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return ary;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readBodies(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        double Tau = 0;
        while (Tau <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int j = 0; j < planets.length; j++) {
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet item : planets) {
                item.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Tau = Tau + dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
