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
    void setDrinkDescription() {

        assertEquals("this is a test description", testDrink.getDescription());
        testDrink.setDescription("1234567890123456789012345678901234567890123456789012345678901234567890"); // upper bound: string length of 70, should fail
        assertEquals("this is a test description", testDrink.getDescription());
        testDrink.setDescription("12345");// lower bound: string length of 5, should fail
        assertEquals("this is a test description", testDrink.getDescription());
        testDrink.setDescription("A valid description that will pass");// within bound: string of length 34, should pass
        assertEquals("A valid description that will pass", testDrink.getDescription());

    }

    @org.junit.jupiter.api.Test
    void setDrinkLocation() {
        assertEquals("Waterford", testDrink.getLocation());
        testDrink.setLocation("1234567890123456789012345"); // upper bound: string length of 25, should fail
        assertEquals("Waterford", testDrink.getLocation());
        testDrink.setLocation("1234"); // lower bound: string length of 4, should fail
        assertEquals("Waterford", testDrink.getLocation());
        testDrink.setLocation("A valid location");// within bound: string of 16, should pass
        assertEquals("A valid location", testDrink.getLocation());

    }
}

