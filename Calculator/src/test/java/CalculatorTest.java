import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final Calculator a = new Calculator();

    @Test
    public void invalidStatement() throws Exception {
        String evaluate = a.evaluate("(2+9s)/3");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement2() throws Exception {
        String evaluate = a.evaluate("(-2.2.2+3)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement3() throws Exception {
        String evaluate = a.evaluate("(-2.+3)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement4() throws Exception {
        String evaluate = a.evaluate("(-2.-3)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement5() throws Exception {
        String evaluate = a.evaluate("(-2./10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement6() throws Exception {
        String evaluate = a.evaluate("(-2.)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement7() throws Exception {
        String evaluate = a.evaluate("(-2.2++)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement8() throws Exception {
        String evaluate = a.evaluate("(-2.2+-)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement9() throws Exception {
        String evaluate = a.evaluate("(-2,2)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement10() throws Exception {
        String evaluate = a.evaluate("(-2*+2)/10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement11() throws Exception {
        String evaluate = a.evaluate("2.2//10");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement12() throws Exception {
        String evaluate = a.evaluate("1.2..+2");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement13() throws Exception {
        String evaluate = a.evaluate("1.2**2");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement14() throws Exception {
        String evaluate = a.evaluate("1.2+-*/2");
        Assert.assertNull(evaluate);
    }

    @Test
    public void invalidStatement15() throws Exception {
        String evaluate = a.evaluate("-1./2/2");
        Assert.assertNull(evaluate);
    }

    @Test
    public void plus() throws Exception {
        a.evaluate("+2");
        Assert.assertNull(null);
    }

    @Test
    public void twoPlusTwoPlusSeven() throws Exception {
        String evaluate = a.evaluate("2+2+7");
        Assert.assertEquals("2+2+7=11.0", evaluate);
    }

    @Test
    public void minusTwoPlusTwoPlusSeven() throws Exception {
        String evaluate = a.evaluate("-2+2+7");
        Assert.assertEquals("-2+2+7=7.0", evaluate);

    }

    @Test
    public void minusTwo() throws Exception {
        String evaluate = a.evaluate("-2");
        Assert.assertEquals("-2=-2.0", evaluate);
    }

    @Test
    public void minusTwoMultThree() throws Exception {
        String evaluate = a.evaluate("-2*3");
        Assert.assertEquals("-2*3=-6.0", evaluate);
    }

    @Test
    public void minusTwoPlusThreeInBracketMultTen() throws Exception {
        String evaluate = a.evaluate("(-2+3)*10");
        Assert.assertEquals("(-2+3)*10=10.0", evaluate);
    }

    @Test
    public void minusTwoPlusThreeInBracketDivTen() throws Exception {
        String evaluate = a.evaluate("(-2+3)/10");
        Assert.assertEquals("(-2+3)/10=0.1", evaluate);
    }

    @Test
    public void minusTwoPointThreeDivTen() throws Exception {
        String evaluate = a.evaluate("-2.3/10");
        Assert.assertEquals("-2.3/10=-0.23", evaluate);
    }

    @Test
    public void minusTwoPointThreeMultTen() throws Exception {
        String evaluate = a.evaluate("-2.3*10");
        Assert.assertEquals("-2.3*10=-23.0", evaluate);
    }

    @Test
    public void test1() throws Exception {
        String evaluate = a.evaluate("2.22226");
        Assert.assertEquals("2.22226=2.2223", evaluate);
    }

    @Test
    public void test2() throws Exception {
        String evaluate = a.evaluate("2.22221");
        Assert.assertEquals("2.22221=2.2222", evaluate);
    }
}