package lesson_1_7_extends.Extends;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar eCar =  new ElectricCar();
        eCar.move();
        eCar.charge();

        GasCar gas = new GasCar();
        gas.move();
        gas.fillUp();
    }
}
