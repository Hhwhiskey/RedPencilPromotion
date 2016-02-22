package com.kevinhodges;

public class RedPencilPromotion {

    private int mDaysOfStablePrice;
    private int mPromoLength;
    private double mOriginalPrice;
    private double mNewPrice;

    public static void main(String[] args) {
    }

    /**
     * Default constructor
     */
    public RedPencilPromotion() {
    }

    /**
     * Constructor to determine if there is currently a Red Pencil Promotion
     *
     * @param daysOfStablePrice days the price has been stable
     * @param promoLength days the promo has been ongoing
     * @param originalPrice original price
     * @param newPrice new price
     *
     **/
    public RedPencilPromotion(int daysOfStablePrice, int promoLength, double originalPrice, double newPrice) {
        mDaysOfStablePrice = daysOfStablePrice;
        mPromoLength = promoLength;
        mOriginalPrice = originalPrice;
        mNewPrice = newPrice;
    }

    /**
     * Check to see if there is currently a RPP
     * @return true if there is currently a Red Pencil Promotion
     */
    public boolean isThereARedPencilPromotion() {

        return isPriceStableForAtLeast30Days(mDaysOfStablePrice)
                && isPromoLengthLessThan30Days(mPromoLength)
                && isPriceReductionBetween5and30Percent(mOriginalPrice, mNewPrice)
                && !isPriceIncreased(mOriginalPrice, mNewPrice);
    }

    /**
     * Determine if the promo is eligible with a stable price of at least 30 days
     *
     * @param daysOfStablePrice amount of days the price has been stable
     * @return true if price has been stable for at least 30 days
     */
    public boolean isPriceStableForAtLeast30Days(int daysOfStablePrice) {
        if (daysOfStablePrice >= 30) {
            return true;
        }
        return false;
    }

    /**
     * Method to determine if the sale is appropriate for the Red Pencil Promotion
     * sale must be between 5 and 30 percent off regular price
     *
     * @param originalPrice the original starting price
     * @param newPrice the discounted/new price
     * @return true if discount is within 5 and 30 percent
     */
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

    /**
     * Method to determin if promo has extended past the max length of 30 days
     *
     * @param promoDays the length of the promo in days
     * @return true if the promo length is less than or equal to 30 days
     */
    public static boolean isPromoLengthLessThan30Days(int promoDays) {
        if (promoDays <= 30) {
            return true;
        }
        return false;
    }

    /**
     * Method to determine if the price increases at any point
     *
     * @param originalPrice original price
     * @param newPrice new price
     * @return true if the new price is higher than the original
     */
    public static boolean isPriceIncreased(double originalPrice, double newPrice) {

        if (newPrice > originalPrice) {
            return true;
        }
        return false;
    }
}
