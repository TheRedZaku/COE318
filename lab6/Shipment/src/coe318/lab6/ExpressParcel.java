
package coe318.lab6;

class ExpressParcel extends StandardParcel {
    
    private final boolean sameDay;

    public ExpressParcel(double weightKg, double distanceKm, boolean insured,
                         String sizeTier, boolean sameDay) {
        super(weightKg, distanceKm, insured, sizeTier);
        this.sameDay = sameDay;
       //TO DO: Complete the constructor
    }

    @Override
    public double shippingCost() {
        // Build on Standard cost using super.<method>()
        double cost = super.shippingCost();
        // Express surcharge: faster delivery multiplier + optional same-day fee
        cost *= 1.35; // express speed premium
        if (sameDay == true) {
            return cost + 7.50;
        }
        //TO DO update cost based on sameDay
        return cost; //instead of adding to the if statement, this is essentially the same thing
    }
}