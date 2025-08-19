package lesson_1_9_polymorphism2.IntefaceEx;

public class Duck extends AbstractAnimal implements Fly,Swim{
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void swim() {
        System.out.println("swim");
    }

    @Override
    public void sound(){
        System.out.println("Duck sound");
    }
}
