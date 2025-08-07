package lesson_1_7_extends.overriding;



public class ElectricCar extends Car {
    public void charge() {
        System.out.println("충전");
    }

    @Override
    public void move(){
        System.out.println("차가 빠르게 이동 합니다.");
    }
}
