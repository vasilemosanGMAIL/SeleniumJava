import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getMake());

        List<String> animal = new ArrayList<>();
        animal.add("Cat"); animal.add("Dog"); animal.add("Lizard");
        for(String ani : animal){
            System.out.println(ani);
        }

        List<String> list = new ArrayList<>();
        list.add("Cat1");
        list.add("Dog1");
        list.add("Lizard1");
        for(String item : list) {
            System.out.println(item);
        }
    }
}

class Vehicle {
    private String make = "BMW";

    String getMake() {
        return make;
    }

    public void rev() {
        System.out.println("Vroom!");
    }
}

class Car extends Vehicle {
    private String model = "3 Series";

    @Override
    public String getMake() {
        return super.getMake();
    }

    public String getModel() {
        return model;
    }
}

