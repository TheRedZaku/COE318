
package coe318.lab6;


public class InternationalParcel extends Parcel {
    private static final double CROSSBORDERFEE = 8.00; //this is similar to "#define" in C
    private final String region;      // e.g., "EU", "APAC", "NA"
    private final double customsRate; // 0.0 - 0.25 (percentage of base as duties)

    public InternationalParcel(double weightKg, double distanceKm, boolean insured,
                               String region, double customsRate) {
        super(weightKg, distanceKm, insured);
        if (customsRate < 0 || customsRate > 0.25) {
            throw new IllegalArgumentException("customsRate must be between 0.0 and 0.25");
        }
        this.region = region; //sets the region that the 
        this.customsRate = customsRate;
    }

    @Override
    public double shippingCost() {
       //TO DO  complete this part
       return super.shippingCost() + CROSSBORDERFEE + (super.shippingCost() * customsRate);
       //returns the base shipping cost + the flat fee to cross borders + the customs rate
    }
    
}
