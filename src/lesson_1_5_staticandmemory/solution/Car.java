package lesson_1_5_staticandmemory.solution;

import org.w3c.dom.ls.LSOutput;

public class Car {
    private static int totalCars;
    private String name;

    public Car(String name){
        System.out.println("차량 구입 : " + name);
        this.name = name;
        totalCars++;
    }
    public static void showTotalCars(){ //정적 메서드이기 때문에 정적 변수에 접근 가능
        System.out.println("구매한 차량 수 :  " + totalCars);
    }
}
