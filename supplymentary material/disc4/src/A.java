class A {
    public int x = 5;

    public void m1() {
        System.out.println("Am1-> " + x);
    }

    public void m2() {
        System.out.println("Am2-> " + this.x);
    }

    public void update() {
        x = 99;
    }
}

class B extends A {

    public void m2() {
        System.out.println("Bm2-> " + x);
    }

    public void m2(int y) {
        System.out.println("Bm2y-> " + y);
    }

    public void m3() {
        System.out.println("Bm3-> " + "called");
    }
}


class C extends B {
    public int y = x + 1;

    public void m2() {
        System.out.println("Cm2-> " + super.x);
    }

    public void m4() {
        //System.out.println("Cm4-> " + super.super.x);
    }

    public void m5() {
        System.out.println("Cm5-> " + y);
    }
}

class D {
    public static void main(String[] args) {
        //B a0 = new A(); B must > A
        //a0.m1();
        //a0.m2(16);
        A b0 = new B();
        System.out.println(b0.x);
        b0.m1();
        b0.m2();
        //b0.m2(61);
        B b1 = new B();
        b1.m2(61);
        b1.m3();
        A c0 = new C();
        c0.m2();
        //C c1 = (A) new C();
        A a1 = (A) c0;
        C c2 = (C) a1;//c2 compile type C, runtime type C.
        c2.m1();//inherited from class A
        c2.m3();//inherited from class
        c2.m4();
        c2.m5();
        ((C) c0).m3();
        //(C) c0.m3();
        b0.update();
        b0.m1();
    }
}