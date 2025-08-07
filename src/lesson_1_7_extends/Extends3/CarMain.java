package lesson_1_7_extends.Extends3;



public class CarMain {
    public static void main(String[] args) {
      ElectricCar eCar =  new ElectricCar();
        eCar.move();
        eCar.openDoor();
        eCar.charge();

       GasCar gas = new GasCar();
        gas.move();
        gas.openDoor();
        gas.fillUp();

        HydrogenCar hydrogen = new HydrogenCar();
        hydrogen.move();
        hydrogen.openDoor();
        hydrogen.fillHydrogen();
    }
}
