import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Mock
    private Bun bun;

    @Before
    public void setUp(){
        burger = new Burger();
        ingredient1 = new Ingredient(IngredientType.SAUCE,"космос с соусом", 700);
        ingredient2 = new Ingredient(IngredientType.FILLING,"космос с начинкой", 300);
        ingredient3 = new Ingredient(IngredientType.FILLING,"космос22131313", 500);

        burger.ingredients.clear();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
    }

    @Test
    public void addIngredientBurger(){
        Ingredient ingredientNew = new Ingredient(IngredientType.SAUCE,"космос с соусом", 400);
        burger.addIngredient(ingredientNew);
        assertTrue(burger.ingredients.contains(ingredientNew));
    }

    @Test
    public void removeIngredientBurger(){
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredientBurger(){
        burger.moveIngredient(1,0);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBurger(){
        Bun bun = new Bun("морковка", 19.0f);
        burger.setBuns(bun);
        float actual = burger.getPrice();
        float expected = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();
        assertEquals(expected,actual,0);
    }

    @Test
    public void getReceiptBurger(){
        Bun bun = new Bun("морковка", 19.0f);
        burger.setBuns(bun);
        String actual = burger.getReceipt();
        assert(!actual.isEmpty());
    }
}
