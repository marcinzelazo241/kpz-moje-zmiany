import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSampleClass{

    private final SampleClass obj = new SampleClass();

    @Test
    void testBasic(){
        Assertions.assertEquals(80.0,obj.calculate(100.0,20.0));
    }

    @Test
    void testException(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                obj.calculate(-10.0,10.0));
    }

    @Test
    void testAbovePercent(){
        Assertions.assertEquals(100.0,obj.calculate(100.0,150.0));
    }

    @Test
    void testBelowPercent(){
        Assertions.assertEquals(100.0,obj.calculate(100.0,-10.0));
    }

}
