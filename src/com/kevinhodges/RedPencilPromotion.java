package com.kevinhodges;

public class RedPencilPromotion {

    public static void main(String[] args) {
	// write your code here
    }

    // Getter for promo eligibility
    // If price has been stable for 30 or more days, return true
    public boolean getPromoEligibility(int daysOfStablePrice) {
        if (daysOfStablePrice >= 30) {
            return true;
        }
        return false;
    }
}
