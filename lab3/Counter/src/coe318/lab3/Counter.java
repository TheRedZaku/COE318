/**
 *
 * @author Your Name
 */
package coe318.lab3;
public class Counter {
    //Instance variables here
    private int digit, modulus; //reusing the same names to make processing
    private Counter left; //which variable is which easier
    
    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left = left; //counter is self referencing
        digit = 0; 
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return left;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        digit++;
        if (digit == modulus) {
            this.setDigit(0);
            if (left != null) { //also checks if the digit is 0 -> meaning it has rolled over
                left.increment(); //doesn't need to be included in the if statement since it is nested
            }
        }
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if (left == null) { //returns the count equal to the digit if there is no counter to the left
            return digit;
        } else {
            return digit + (modulus * left.getCount()); //gets the count of the counter to the left
        } //recognize that getCount() returns the value of the digit and not the counter itself, which is getLeft instead
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
