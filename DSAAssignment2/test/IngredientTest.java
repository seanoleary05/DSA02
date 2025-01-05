import static org.junit.jupiter.api.Assertions.assertEquals;
public class IngredientTest {
    Ingredient testIngredient = new Ingredient("testIngredient", "this is a test description", 6.4F);


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testIngredient = new Ingredient("testIngredient", "this is a test description", 6.4F);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        testIngredient = null;
    }



    @org.junit.jupiter.api.Test
    void testIngredientName() {
        assertEquals("testIngredient", testIngredient.getiName());
        testIngredient.setiName("12345678901234567890"); // upper bound: string length of 20, should fail
        assertEquals("testIngredient", testIngredient.getiName());
        testIngredient.setiName("1234");// lower bound string length of 4: should fail
        assertEquals("testIngredient", testIngredient.getiName());
        testIngredient.setiName("newIngredient");// within bound: string length of 13: should pass
        assertEquals("newIngredient", testIngredient.getiName());
    }

    @org.junit.jupiter.api.Test
    void testIngredientABV(){
        assertEquals(6.4F, testIngredient.getABV());
        testIngredient.setABV(0.001F); // lower bound, should fail
        assertEquals(6.4F, testIngredient.getABV());
        testIngredient.setABV(99.9999F); // higher bound, should fail
        assertEquals(6.4F, testIngredient.getABV());
        testIngredient.setABV(50F);// within bound, should pass
        assertEquals(50F, testIngredient.getABV());

    }
}
