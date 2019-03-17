public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int firstItemInFile = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num_of_plnts = in.readInt();
        double item = in.readDouble();
        Planet[] planets = new Planet[num_of_plnts];
        for(int i = 0; i < num_of_plnts; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();

            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for(Planet body:planets){
            body.draw();
        }

//        StdAudio.loop("audio/2001.mid");
        StdDraw.pause(100);
        StdDraw.clear();

        System.out.println("Initial...");
        StdDraw.enableDoubleBuffering();
        StdDraw.show();

        int time = 0;
        while(time < T){
//            System.out.println("begin...");
            double[] arr_x_force = new double[planets.length];
            double[] arr_y_force = new double[planets.length];

            for(int i = 0; i < planets.length; i++){
                arr_x_force[i] = planets[i].calcNetForceExertedByX(planets);
                arr_y_force[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, arr_x_force[i], arr_y_force[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet body:planets){
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            StdDraw.clear();
            time += dt;

            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }
        }

    }
}
