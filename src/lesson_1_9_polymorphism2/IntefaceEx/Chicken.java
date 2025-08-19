package lesson_1_9_polymorphism2.IntefaceEx;

public class Chicken extends AbstractAnimal implements Fly {
    @Override
    public void fly() {
        System.out.println("can't fly");
    }

    @Override
    public void sound() {
        System.out.println("chicken sound");
    }
}
