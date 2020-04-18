public class TestAnimals {
    public static void main(String[] args) {
        //a compile type = Animal
        Animal a = new Animal("Pluto", 10);
        //c compile type = Cat
        Cat c = new Cat("Garfield", 6);
        //d compile type = Dog
        Dog d = new Dog("Fido", 4);
        a.greet();
        c.greet();
        d.greet();
        //a runtime type = Cat
        a = c;
        ((Cat) a).greet();
        a.greet();

        a = new Dog("spot", 10);
        //d = a; this line won't compile.
    }
}

