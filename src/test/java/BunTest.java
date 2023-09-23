import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    Bun bun;

    @Test
    public void getNameBun() {
        Bun bun = new Bun ("космос", 300.50F);
        String actualResult = bun.getName();
        String expectedResult = "космос";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNameBunMock () {
        Mockito.when(bun.getName()).thenReturn("галактика");
        String actualResult = bun.getName();
        String expectedResult = "галактика";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun ("космос", 300.01F);
        float actualResult = bun.getPrice();
        float expectedResult = 300.01F;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getPriceBunMock () {
        Mockito.when(bun.getPrice()).thenReturn(900.5F);
        float actualResult = bun.getPrice();
        float expectedResult = 900.5F;
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

}
