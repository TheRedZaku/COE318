
package coe318.lab6;


class StandardParcel extends Parcel {
    // sizeTier: S/M/L affects handling
    protected final String sizeTier;

    public StandardParcel(double weightKg, double distanceKm, boolean insured, String sizeTier) {
        super(weightKg, distanceKm, insured); //assigns weight, distance and insurance from the constructor of the super
        if (!sizeTier.matches("[SML]")) {
            throw new IllegalArgumentException("sizeTier must be S, M, or L");
        }
        this.sizeTier = sizeTier;
    }

    @Override
    public double shippingCost() {
        double cost = super.shippingCost(); //uses the shipping cost of the super class
        double handling= 0;
        switch (sizeTier) {
            case "S" -> handling = 0.75;
            case "M" -> handling = 1.25;
            default -> handling = 1.75;
        }
        //TO DO -> I think this should be good
        //Write lines of codes that calculates handeling based on sizeTier
        return cost + handling;
    }

}
