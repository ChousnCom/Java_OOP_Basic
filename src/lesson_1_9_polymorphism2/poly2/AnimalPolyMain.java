package lesson_1_9_polymorphism2.poly2;

public class AnimalPolyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
    }
    private static void soundAnimal(Animal animal){
        System.out.println("소리 테스트");
        animal.sound();
    }
}
