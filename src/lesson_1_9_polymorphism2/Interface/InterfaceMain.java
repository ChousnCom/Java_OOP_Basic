package lesson_1_9_polymorphism2.Interface;

public class InterfaceMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        soundAnimal(dog);
        moveAnimal(dog);
        soundAnimal(cat);
        moveAnimal(cat);
    }
    private static void soundAnimal(InterfaceAnimal animal) {
        animal.sound();
    }

    private static void moveAnimal(InterfaceAnimal animal) {
        animal.move();
    }
}
