package coe318.lab7;

/**
 *
 * @author Kevin L
 */
public class Car extends Vehicle {
    private boolean automatic;

    public Car(String plateNumber, String model, int year, boolean automatic) {
        super(plateNumber, model, year);
        this.automatic = automatic; //determines if the car is automatic or manual
        
  
    }

    public boolean isAutomatic() {
        return automatic;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Car: " + super.toString() +
               (automatic ? " [Automatic]" : " [Manual]"); //outputs manual or automatic using a ternary operator
    }

    
    @Override
    public double calculateRentalPrice(int days) {
        return ((automatic ? 65.0 : 55.0) * days);//TO DO. complete the code such that Daily Rate for automatic cars are 65.0 an for non automatic cars are 55.0. 
    }//using a ternary operator to determine the daily rate

  
    @Override
    public double calculateInsurancePremium(int days) {
        return (super.calculateInsurancePremium(days) * 1.10); //insurance premium is 110% of the original cost for insurance
    // TO DO. complete the code, such that the daily insurence rate is the vehicle’s base, increased by 10% 
    }


    // Overloaded version with GPS option
    public double calculateRentalPrice(int days, boolean gpsIncluded) {
        double base = calculateRentalPrice(days);
        if (gpsIncluded) {
            base += 10.0 * days; // GPS daily fee
        }
        return base;
    }

    // Static method HIDING superclass static method
    public static void printVehicleType() {
        System.out.println("Car");
    }//cannot override a static method, but you can "hide" the parent method by calling this one in reference to the subclass
    
}
