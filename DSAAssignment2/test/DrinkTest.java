import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkTest {
    Drink testDrink = new Drink("testDrink", "this is a test description", "Waterford", "image.com");

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testDrink = new Drink("testDrink", "this is a test description", "Waterford", "image.com");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testDrink = null;
    }


    @org.junit.jupiter.api.Test
    void setDrinkName() {
        assertEquals("testDrink", testDrink.getName());
        testDrink.setName("1234567890123456789012345"); // upper bound: string length of 25, should fail
        assertEquals("testDrink", testDrink.getName());
        testDrink.setName("123"); // lower bound: string length of 3, should fail
        assertEquals("testDrink", testDrink.getName());
        testDrink.setName("ANewTestDrink");// within bound: string length of 13, should pass
        assertEquals("ANewTestDrink", testDrink.getName());

    }

    @org.junit.jupiter.api.Test
    void setDrink() {
//

    }
}
