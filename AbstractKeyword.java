
// Abstract keyword is used to implement abstraction 
// Only abstract classes can have abstract methods
// objects of abstract classes cannot be made
// class inheriting an abstract class should implement all its abstract methods

abstract class Car {
    public abstract void drive();

    public abstract void playMusic();
}

// class WagonR extends Car{

// public void drive() {
// System.out.println("Drive");
// }

// public void playMusic() {
// System.out.println("Play Music");
// }

// }

// ======================================

abstract class WagonR extends Car {
    public void drive() {
        System.out.println("Drive");
    }
}

class AdvWagonR extends WagonR{

    public void playMusic() {
        System.out.println("play Music");
    }
    
}



public class AbstractKeyword {
    public static void main(String[] args) {
        // Car car = new Car(); //Cannot make an object of abstract class
        // WagonR car = new WagonR();
        // car.drive();
        // car.playMusic();

        // ================================

        // WagonR car = new WagonR() // 

        AdvWagonR car = new AdvWagonR();
        car.drive();
        car.playMusic();

    }
}
