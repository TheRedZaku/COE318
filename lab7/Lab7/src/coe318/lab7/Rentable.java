package coe318.lab7;

/**
 *
 * @author Kevin L
 */
public interface Rentable {
    
    double calculateRentalPrice(int days);

    void startRental();

    void endRental();
    
}