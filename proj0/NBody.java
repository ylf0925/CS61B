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
        Body[] Planets = NBody.readBodies(filename);
        StdDraw.setScale(-uniRadius, uniRadius);
        StdDraw.enableDoubleBuffering();
        double Tau = 0;
        while (Tau <= T) {
            double[] xForces = new double[Planets.length];
            double[] yForces = new double[Planets.length];
            for (int j = 0; j < Planets.length; j++) {
                xForces[j] = Planets[j].calcNetForceExertedByX(Planets);
                yForces[j] = Planets[j].calcNetForceExertedByY(Planets);
            }
            for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body body : Planets) {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Tau = Tau + dt;
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }
}
