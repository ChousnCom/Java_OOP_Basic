package lesson_1_9_polymorphism2.Interface;

public class DiaMain {
    public static void main(String[] args) {
        InterfaceA a = new Child();
        InterfaceB b = new Child();
        a.methodA();
        a.methodCommon();

        b.methodB();
        b.methodCommon();
    }
}
