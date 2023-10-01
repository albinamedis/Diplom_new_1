import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.IngredientType;
import praktikum.Ingredient;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter
    public IngredientType type;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public float price;

    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Для поля {0} вернуть {1}")
    public static Object [][] params() {
        return new Object[][] {
                {IngredientType.SAUCE,"космос1 с соусом", 770.59F},
                {IngredientType.FILLING,"космос2 с начинкой", 300.50F},
        };
    }

    @Test
    public void getTypeIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = type;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getTypeIngredientMock(){
        Mockito.when(ingredient.getType()).thenReturn(type);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = type;
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void getNameIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualResult = ingredient.getName();
        String expectedResult = name;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNameIngredientMock(){
        Mockito.when(ingredient.getName()).thenReturn(name);
        String actualResult = ingredient.getName();
        String expectedResult = name;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getPriceIngredientMock(){
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        float actualResult = ingredient.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }
}
