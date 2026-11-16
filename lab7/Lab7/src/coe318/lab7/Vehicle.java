package coe318.lab7;

/**
 *
 * @author Kevin L
 */
public class Vehicle implements Insurable, Rentable {
    private String plateNumber;
    private String model;
    private int year;
    final private double DefaultRentPrice=100;

    public Vehicle(String plateNumber, String model, int year) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
    } //constructor sets basic information for the vehicle
        
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public String toString() {
        return year + " " + model + " (" + plateNumber + ")";
    }

    @Override
    public double calculateRentalPrice(int days){//implemented from interface
        return(DefaultRentPrice*days); //when a class implements this class, it can change the rent per day pricing
    }

    @Override
    public double calculateInsurancePremium(int days) {//implemented from interface
        return getBaseInsuranceRate() * days;
    }

    @Override
    public void startRental() {//implemented from interface
        System.out.println("Starting rental for " + this.toString());
    }

    @Override
    public void endRental() {//implemented from interface
        System.out.println("Ending rental for " + this.toString());
    }

    public final double getBaseInsuranceRate() {
        return 20.0; 
    }

    public final void printPlate() {
        System.out.println("Plate: " + plateNumber);
    }

    public static void printVehicleType() {
        System.out.println("Generic Vehicle");
    }

}