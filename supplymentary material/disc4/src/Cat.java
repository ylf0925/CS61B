public class Cat extends Animal {


    public Cat(String name, int age) {
        super(name, age); //Call superclass' constructor
        this.noise = "Meow";
    }


    public static void main(String[] args) {
        Animal a = new Cat("qiuqiu", 2);
        Cat c = new Cat("xiaoqiu", 21);
        c.greet();
    }


    @Override
    public void greet() {
        System.out.println("Cat" + name + " says:" + makeNoise());
    }
}
