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
    public void promoInsideEligiblePeriod() {
        //Arrange

        //Act
        boolean result = promo.getPromoEligibility(30);

        //Assert
        assertTrue(result);
    }

    @Test
    public void promoOutsideEligiblePeriod() {
        //Arrange

        //Act
        boolean result = promo.getPromoEligibility(50);

        //Assert
        assertFalse(result);
    }



}


