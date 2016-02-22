package com.kevinhodges;

public class RedPencilPromotion {

    public static void main(String[] args) {
    }

    // Determine if promo is inside the eligible period
    // If price has been stable for 30 or more days, return true
    public boolean isPromoInsideEligiblePeriod(int daysOfStablePrice) {
        if (daysOfStablePrice >= 30) {
            return true;
        }
        return false;
    }

    // Method to determine if the sale is appropriate for the Red Pencil Promotion
    public static boolean isPriceReductionBetween5and30Percent(double originalPrice, double newPrice) {

        // Subtract the reduced price from the original price, then divide that by the original price
        // Muliply this by -100 to get the positive percentage of the sale
        double percentageOfSale = (((newPrice - originalPrice) / originalPrice) * -100);

        // Check to see if the sale falls between this eligible range
        if (percentageOfSale >= 5.00 && percentageOfSale <= 30.00) {
            return true;
        }
        return false;
    }

    // Method to determine if the promo has extended past the max length of 30 days
    public static boolean isPromoLengthLessThan30Days(int promoDays) {
        if (promoDays <= 30) {
            return true;
        }
        return false;
    }

    // Method to determine if promo price increases at any point
    public static boolean isPriceIncreased(double originalPrice, double newPrice) {

        if (newPrice > originalPrice) {
            return true;
        }
        return false;
    }
}
