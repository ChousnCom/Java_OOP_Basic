package lesson_1_9_polymorphism2.poly2;

public class AnimalPolyMain3 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        Animal [] animals = {dog,cat,caw};
        for(Animal animal : animals) {
            soundAnimal(animal);
        }
    }
    private static void soundAnimal(Animal animal){
        System.out.println("동물 소리");
        animal.sound();
    }
}
