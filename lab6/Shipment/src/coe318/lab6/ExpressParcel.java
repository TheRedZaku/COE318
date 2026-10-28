
package coe318.lab6;

class ExpressParcel extends StandardParcel {
    private final boolean sameDay;

    public ExpressParcel(double weightKg, double distanceKm, boolean insured,
                         String sizeTier, boolean sameDay) {
       //TO DO: Complete the constructor
    }

    @Override
    public double shippingCost() {
        // Build on Standard cost using super.<method>()
        double cost = super.shippingCost();
        // Express surcharge: faster delivery multiplier + optional same-day fee
        cost *= 1.35; // express speed premium
        //TO DO update cost based on sameDay
        return cost;
    }
}