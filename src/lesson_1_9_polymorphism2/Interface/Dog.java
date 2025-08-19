package lesson_1_9_polymorphism2.Interface;

public class Dog implements InterfaceAnimal {

    @Override
    public void move() {
        System.out.println("Dog move");
    }

    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
}
