package lesson_1_9_polymorphism2.poly;

public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat  = new Cat();
        Caw caw = new Caw();

        dog.sound();
        cat.sound();
        caw.sound();
    }
}
//다형적 참조를 활용하지 않고 코드를 동물의 울음을 출력하는 프로그램 작성
//동물이 추가될때마다, 클래스를 만들어야 하며 각 인스턴스도 따로 계속 만들어 줘야함.
//서로 타입 또한 다르기 때문에 메서드나 배열 혹은 반복을 통한 리팩토링을 할 수 없음.
