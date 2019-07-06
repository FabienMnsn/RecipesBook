package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import obj.Ingredient;


public class IngredientTest {
	@Test
	public void testIngredients() {
		Ingredient i = new Ingredient("lait", 2, "L");
		System.out.println(i.toString());
		assertEquals("[lait, 2.0, L]", i.toString());
	}
}
