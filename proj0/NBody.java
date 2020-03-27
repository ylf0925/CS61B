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
        double radius = NBody.readRadius(filename);
        Body[] bodies = NBody.readBodies(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        double Tau = 0;
        while (Tau <= T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int j = 0; j < bodies.length; j++) {
                xForces[j] = bodies[j].calcNetForceExertedByX(bodies);
                yForces[j] = bodies[j].calcNetForceExertedByY(bodies);
            }
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body body : bodies) {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Tau = Tau + dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
