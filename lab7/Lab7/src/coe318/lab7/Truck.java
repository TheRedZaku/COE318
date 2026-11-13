/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author Kevin L
 */
public class Truck  extends Vehicle {
    private double loadCapacityInTons;

    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
        super(plateNumber, model, year);
        this.loadCapacityInTons = loadCapacityInTons;
      
    }

    public double getLoadCapacityInTons() {
        return loadCapacityInTons;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() +
               " [Capacity: " + loadCapacityInTons + " tons]";//overriden to show "truck" and to also show the load capacity
    }

    @Override
    public double calculateRentalPrice(int days) {
        // TO DO  when a daily rate  starts at 90 dollars and increases by 10 dollars for each ton of load capacity.
        return (days*(90.0 + (10.0*getLoadCapacityInTons())));
    }

    @Override
    public double calculateInsurancePremium(int days) {
       // TO Do: the daily rate is the base insurance rate increased by 50 percent
       return (super.calculateInsurancePremium(days)*1.50); //150% of the base cost
    }

    public static void printVehicleType() {
        System.out.println("Truck"); //outputs truck instead of generic vehicle
    }
    
}