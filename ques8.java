interface Vehicle {
    // Abstract method
    void start();

    // Default method
    default void stop() {
        System.out.println("The vehicle is stopping.");
    }

    // Static method
    static void service() {
        System.out.println("The vehicle is being serviced.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("The car is starting.");
    }

    // Optionally override the default method
    @Override
    public void stop() {
        System.out.println("The car is stopping.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); // Calls the implemented start method
        myCar.stop();  // Calls the overridden stop method
        
        // Call the static method from the interface
        Vehicle.service();
    }
}
