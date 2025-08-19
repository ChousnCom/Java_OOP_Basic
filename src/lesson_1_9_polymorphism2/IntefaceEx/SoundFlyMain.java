package lesson_1_9_polymorphism2.IntefaceEx;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Chicken chicken = new Chicken();
        Duck duck = new Duck();

        sound(dog);
        sound(chicken);
        sound(duck);

        fly(chicken);
        fly(duck);

        swim(duck);
    }
    private static void sound(AbstractAnimal animal){
        animal.sound();
    }

    private static void fly(Fly fly){
        fly.fly();
    }

    private static void swim(Swim swim){
        swim.swim();
    }
}
