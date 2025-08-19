package lesson_1_9_polymorphism2.Interface;

public class Cat implements InterfaceAnimal {
    @Override
    public void move() {
        System.out.println("Cat move");
    }

    @Override
    public void sound() {
        System.out.println("Cat sound");
    }
}
