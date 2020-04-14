public class Salmon extends Fish {

    String home;

    public Salmon(int w, String h) {
        super(w);
        home = h;
    }

    public void migrate() {
        System.out.println("Migrating to" + home);
    }

    /**
     * overriding
     */

    public void swim() {
        System.out.println("Splashhhhh");
    }

    /**
     * overloading
     */

    public void swim(int speed) {
        System.out.println("swimming at" + " " + speed + " " + "mph");
    }

    public static void main(String[] args) {
        Fish f = new Fish(4);
        Salmon s = new Salmon(10, "China");
        Fish bob = new Salmon(7, "Belgium");

        f.swim();
        s.swim();
        bob.swim();

        ((Salmon) bob).swim(5);


    }
}