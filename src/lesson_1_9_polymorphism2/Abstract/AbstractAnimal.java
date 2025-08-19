package lesson_1_9_polymorphism2.Abstract;

public abstract class AbstractAnimal {

    public abstract void sound(); // 추상 메서드 자식이 반드시 오버라딩 해야함.

    public void move(){
        System.out.println("동물이 움직입니다.");
    }
}
