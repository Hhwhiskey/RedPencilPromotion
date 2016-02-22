package Test;

import com.kevinhodges.RedPencilPromotion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
    These parameters outline the requirements for the Red Pencil Promotion
    1)  Starts only after 30 days of stable price
    2)  Starts when price is reduced by at least 5% but no more than 30%
    3)  Lasts up to 30 days max, no minimum time specified
    4a) If the price is reduced further, the length of the promo does not change
    4b) Unless the price is reduced by over 30% of original, this will end the promo immediately
    5)  If the price is increased at any point, the promo will end immediately
    6)  After the promo ends, others may follow as long as condition (1) is met
*/

public class RedPencilPromotionTest {

    private RedPencilPromotion promo;

    @Before
    public void setUp() {
        promo = new RedPencilPromotion();
    }

    @Test
    public void priceHasBeenStableForAtLeast30Days() {
        //Arrange
        //Passing in 30 days should return true

        //Act
        boolean result = promo.isPriceStableForAtLeast30Days(30);

        //Assert
        assertTrue(result);
    }

    @Test
    public void priceHasNotBeenStableForAtLeast30Days() {
        //Arrange
        //Passing in 20 days should return false

        //Act
        boolean result = promo.isPriceStableForAtLeast30Days(20);

        //Assert
        assertFalse(result);
    }

    @Test
    public void saleIsWithin5and30Percent() {
        //Arrange
        //Passing in 100.00 and 75.00 ($) should return true

        //Act
        boolean result = promo.isPriceReductionBetween5and30Percent(100.00, 75.00);

        //Assert
        assertTrue(result);
    }

    @Test
    public void saleIsNotWithin5and30Percent() {
        //Arrange
        //Passing in 100.00 and 25.00 ($) should return false

        //Act
        boolean result = promo.isPriceReductionBetween5and30Percent(100.00, 25.00);

        //Assert
        assertFalse(result);
    }

    @Test
    public void promoLengthLessThan30Days() {
        //Arrange
        //Passing in 25 days should return true

        //Act
        boolean result = promo.isPromoLengthLessThan30Days(25);

        //Assert
        assertTrue(result);
    }

    @Test
    public void promoLengthLongerThan30Days() {
        //Arrange
        //Passing in 50 days should return false

        //Act
        boolean result = promo.isPromoLengthLessThan30Days(50);

        //Assert
        assertFalse(result);
    }

    @Test
    public void priceIncreaseRemovesPromoStatus() {
        //Arrange
        //Passing in 10.00 and 15.00 ($) should return true

        //Act
        boolean result = promo.isPriceIncreased(10.00, 15.00);

        //Assert
        assertTrue(result);
    }

    @Test
    public void priceReductionRemovesPromoStatus() {
        //Arrange
        //Passing in 20.00 and 10.00 ($) should return false

        //Act
        boolean result = promo.isPriceIncreased(20.00, 10.00);

        //Assert
        assertFalse(result);
    }

    @Test
    public void thereIsARedPencilPromotion() {
        //Arrange
        //This will create a RedPencilPromotion object that agrees with a current Red Pencil Promotion
        //and should return true
        int daysOfStablePrice = 30;
        int daysOfPromoLength = 15;
        double startingPrice = 15.00;
        double newPrice = 12.00;

        promo = new RedPencilPromotion(daysOfStablePrice, daysOfPromoLength, startingPrice, newPrice);

        //Act
        boolean result = promo.isThereARedPencilPromotion();

        //Assert
        assertTrue(result);
    }

    @Test
    public void thereIsNotARedPencilPromotion() {
        //Arrange
        //This will create a RedPencilPromotion object that disagrees with a current Red Pencil Promotion
        //and should return false
        int daysOfStablePrice = 20;
        int daysOfPromoLength = 32;
        double startingPrice = 10.00;
        double newPrice = 12.00;

        promo = new RedPencilPromotion(daysOfStablePrice, daysOfPromoLength, startingPrice, newPrice);

        //Act
        boolean result = promo.isThereARedPencilPromotion();

        //Assert
        assertFalse(result);
    }










}