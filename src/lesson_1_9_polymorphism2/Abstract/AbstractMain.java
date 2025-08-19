package lesson_1_9_polymorphism2.Abstract;

public class AbstractMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw  = new Caw();

        cat.sound();
        cat.move();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

    }
    private static void soundAnimal(AbstractAnimal animal){
        animal.sound();
    }
}
