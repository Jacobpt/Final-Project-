import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCases {
    SampleClass testClass;

    @Before
    public void setup(){
        testClass = new SampleClass();
    }

    @Test
    public void testAddOne()
    {
        assertEquals(testClass.getSCint(), 0);
        testClass.AddOne();
        assertEquals(testClass.getSCint(), 1);
    }
    @Test
    public void testSetFields()
    {

        testClass.setSCint(42);
        testClass.setSCstring("Hello");
        assertEquals(testClass.getSCint(), 42);
        assertEquals(testClass.getSCstring(), "Hello");
    }

    @Test
    public void testChangeString()
    {
        assertEquals(testClass.getSCint(), 0);
        assertEquals(testClass.getSCstring(), "");

        testClass.setSCint(42);
        testClass.SetStringToInt();
        assertEquals(testClass.getSCstring(), "42");

    }
}
