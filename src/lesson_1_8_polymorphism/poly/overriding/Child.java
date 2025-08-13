package lesson_1_8_polymorphism.poly.overriding;

public class Child extends Parent {
    public String value = "Child";

    @Override
    public void method() {
        System.out.println("Child.methods");
    }
}
